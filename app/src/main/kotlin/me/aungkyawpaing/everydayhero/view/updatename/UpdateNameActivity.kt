package me.aungkyawpaing.everydayhero.view.updatename

import android.content.Context
import android.content.Intent
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_first_time.btn_go
import kotlinx.android.synthetic.main.activity_first_time.et_name
import kotlinx.android.synthetic.main.activity_first_time.layout_default
import kotlinx.android.synthetic.main.activity_first_time.layout_loading
import me.aungkyawpaing.everydayhero.R
import me.aungkyawpaing.everydayhero.dagger.components.DaggerUpdateNameActivityComponent
import me.aungkyawpaing.everydayhero.dagger.modules.AuthModule
import me.aungkyawpaing.everydayhero.presenter.UpdateNamePresenter
import me.aungkyawpaing.everydayhero.utils.setVisible
import me.aungkyawpaing.everydayhero.utils.showShortToast
import me.aungkyawpaing.everydayhero.view.core.BaseActivity
import me.aungkyawpaing.everydayhero.view.main.MainActivity
import javax.inject.Inject

/**
 * Created by vincentpaing on 8/27/17.
 */
class UpdateNameActivity : BaseActivity(), UpdateNameView {

  @Inject lateinit var updateNamePresenter: UpdateNamePresenter

  override val layoutResId: Int
    get() = R.layout.activity_first_time


  companion object {
    fun start(context: Context) {
      val intent = Intent(context, UpdateNameActivity::class.java)
      intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
      intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
      context.startActivity(intent)
    }
  }

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    initDagger()

    if (savedInstanceState == null) {
      updateNamePresenter.setView(this)
      updateNamePresenter.init()
    }

    setupLayout()
  }

  private fun setupLayout() {
    btn_go.setOnClickListener {
      updateNamePresenter.updateName(et_name.text.toString())
    }
  }

  protected fun initDagger() {
    DaggerUpdateNameActivityComponent.builder()
        .appComponent(appComponent)
        .authModule(AuthModule(this))
        .build()
        .inject(this)
  }

  override fun showUpdateSuccess() {
    MainActivity.start(this)
    this.finish()
  }

  override fun showLoading() {
    layout_default.setVisible(false)
    layout_loading.setVisible(true)
  }

  override fun hideLoading() {
    layout_default.setVisible(true)
    layout_loading.setVisible(false)
  }


  override fun showRetry() {
  }

  override fun hideRetry() {
  }

  override fun showError(message: String) {
    showShortToast(message)
  }

  override fun context(): Context = applicationContext

  override fun onDestroy() {
    super.onDestroy()
    updateNamePresenter.destroy()
  }

}
