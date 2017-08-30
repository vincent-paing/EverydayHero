package me.aungkyawpaing.everydayhero.view.main

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.aungkyawpaing.domain.consume
import kotlinx.android.synthetic.main.activity_main.bottom_nav
import me.aungkyawpaing.everydayhero.R
import me.aungkyawpaing.everydayhero.dagger.components.DaggerMainActivityComponent
import me.aungkyawpaing.everydayhero.presenter.CheckLoginPresenter
import me.aungkyawpaing.everydayhero.utils.showShortToast
import me.aungkyawpaing.everydayhero.view.avatarpack.AvatarPackFragment
import me.aungkyawpaing.everydayhero.view.core.BaseActivity
import me.aungkyawpaing.everydayhero.view.login.LoginActivity
import me.aungkyawpaing.everydayhero.view.quest.QuestFragment
import me.aungkyawpaing.everydayhero.view.settings.SettingsFragment
import me.aungkyawpaing.everydayhero.view.updatename.UpdateNameActivity
import javax.inject.Inject


/**
 * Created by vincentpaing on 8/5/17.
 */
class MainActivity : BaseActivity(), CheckLoginView {


  @Inject lateinit var checkLoginPresenter: CheckLoginPresenter

  companion object {
    fun start(context: Context) {
      val intent = Intent(context, MainActivity::class.java)
      intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
      intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
      context.startActivity(intent)
    }
  }

  override val layoutResId: Int
    get() = R.layout.activity_main


  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    initDagger()

    if (savedInstanceState == null) {
      checkLoginPresenter.setView(this)
      checkLoginPresenter.init()
    }
  }

  private fun initDagger() {
    DaggerMainActivityComponent.builder()
        .appComponent(appComponent)
        .build().inject(this)
  }

  private fun setupLayout() {
    bottom_nav.setOnNavigationItemSelectedListener { item ->
      when (item.itemId) {
        R.id.action_shop -> consume { navigateToShop() }
        R.id.action_quest -> consume { navigateToQuest() }
        R.id.action_setting -> consume { navigateToSettings() }
        else -> consume { navigateToQuest() }
      }
    }

    bottom_nav.setOnNavigationItemReselectedListener { item ->
      //DO NOTHING
    }

    bottom_nav.selectedItemId = R.id.action_quest
  }

  override fun showLoading() {

  }

  override fun hideLoading() {
  }

  override fun showRetry() {
  }

  override fun hideRetry() {
  }

  override fun showError(message: String) {
    showShortToast(message)
  }

  override fun context(): Context = applicationContext

  override fun showLoggedIn() {
    setupLayout()
  }

  override fun showNotLoggedIn() {
    LoginActivity.start(this)
    this.finish()
  }

  override fun showFirstTime() {
    UpdateNameActivity.start(this)
    this.finish()
  }

  fun navigateToShop() {
    replaceFragment(R.id.container, AvatarPackFragment.newInstance())
  }

  fun navigateToQuest() {
    replaceFragment(R.id.container, QuestFragment.newInstance())
  }

  fun navigateToSettings() {
    replaceFragment(R.id.container, SettingsFragment.newInstance())
  }

  override fun onDestroy() {
    super.onDestroy()
    checkLoginPresenter.destroy()
  }
}