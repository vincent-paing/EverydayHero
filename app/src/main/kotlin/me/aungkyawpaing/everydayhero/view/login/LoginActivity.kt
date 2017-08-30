package me.aungkyawpaing.everydayhero.view.login

import android.Manifest
import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.facebook.accountkit.AccountKitLoginResult
import com.facebook.accountkit.ui.AccountKitActivity
import com.facebook.accountkit.ui.AccountKitConfiguration
import com.facebook.accountkit.ui.LoginType
import com.greysonparrelli.permiso.Permiso
import com.greysonparrelli.permiso.Permiso.IOnPermissionResult
import com.greysonparrelli.permiso.Permiso.IOnRationaleProvided
import com.greysonparrelli.permiso.Permiso.ResultSet
import kotlinx.android.synthetic.main.activity_login.btn_login
import kotlinx.android.synthetic.main.activity_login.layout_default
import kotlinx.android.synthetic.main.activity_login.layout_loading
import kotlinx.android.synthetic.main.activity_login.view_pager_onboarding
import kotlinx.android.synthetic.main.activity_login.vp_indicator
import me.aungkyawpaing.everydayhero.R
import me.aungkyawpaing.everydayhero.dagger.components.DaggerLoginActivityComponent
import me.aungkyawpaing.everydayhero.dagger.modules.AuthModule
import me.aungkyawpaing.everydayhero.presenter.LoginPresenter
import me.aungkyawpaing.everydayhero.utils.setVisible
import me.aungkyawpaing.everydayhero.utils.showShortToast
import me.aungkyawpaing.everydayhero.view.core.BaseActivity
import me.aungkyawpaing.everydayhero.view.core.FragmentViewPagerAdapter
import me.aungkyawpaing.everydayhero.view.main.MainActivity
import me.aungkyawpaing.everydayhero.view.updatename.UpdateNameActivity
import javax.inject.Inject

/**
 * Created by vincentpaing on 7/30/17.
 */
class LoginActivity : BaseActivity(), LoginView {

  @Inject lateinit var loginPresenter: LoginPresenter
  val ACCOUNT_KIT_REQUEST_CODE = 99
  lateinit var viewPagerAdapter: FragmentViewPagerAdapter

  companion object {
    fun start(context: Context) {
      val intent = Intent(context, LoginActivity::class.java)
      intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
      intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
      context.startActivity(intent)
    }

  }

  override val layoutResId: Int
    get() = R.layout.activity_login

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    initDagger()

    if (savedInstanceState == null) {
      loginPresenter.setView(this)
      loginPresenter.init()
    }
    Permiso.getInstance().setActivity(this)

    setupLayout()
  }

  private fun setupLayout() {
    btn_login.setOnClickListener { onLoginClick() }

    viewPagerAdapter = FragmentViewPagerAdapter(supportFragmentManager)
    viewPagerAdapter.addFrag(OnboardingFragment.newInstance(
        OnboardingFragment.FRAGMENT_ONE))
    viewPagerAdapter.addFrag(OnboardingFragment.newInstance(
        OnboardingFragment.FRAGMENT_TWO))
    viewPagerAdapter.addFrag(OnboardingFragment.newInstance(
        OnboardingFragment.FRAGMENT_THREE))

    view_pager_onboarding.adapter = viewPagerAdapter
    vp_indicator.setViewPager(view_pager_onboarding)
  }

  private fun onLoginClick() {


    val onPermissionResult = object : IOnPermissionResult {

      override fun onRationaleRequested(callback: IOnRationaleProvided?,
          vararg permissions: String?) {
        Permiso.getInstance().showRationaleInDialog("Request for Permission",
            "We utilize these permissions to make the verification process faster", null,
            callback!!);
      }

      override fun onPermissionResult(resultSet: ResultSet?) {
        loginPresenter.verifyPhoneNumber()
      }

    }

    Permiso.getInstance().requestPermissions(onPermissionResult,
        Manifest.permission.READ_PHONE_STATE, Manifest.permission.RECEIVE_SMS)
  }

  protected fun initDagger() {
    DaggerLoginActivityComponent.builder()
        .appComponent(appComponent)
        .authModule(AuthModule(this))
        .build()
        .inject(this)
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

  override fun context(): Context {
    return applicationContext
  }

  override fun onResume() {
    super.onResume()
    Permiso.getInstance().setActivity(this)
  }

  override fun onDestroy() {
    super.onDestroy()
    loginPresenter.destroy()
  }

  override fun navigateToMainView() {
    MainActivity.start(this)
    this.finish()
  }

  override fun navigateToHeroNameView() {
    UpdateNameActivity.start(this)
    this.finish()
  }

  override fun showPhoneNumberValidation() {
    val intent = Intent(this, AccountKitActivity::class.java)
    val configurationBuilder = AccountKitConfiguration.AccountKitConfigurationBuilder(
        LoginType.PHONE,
        AccountKitActivity.ResponseType.CODE)
    intent.putExtra(
        AccountKitActivity.ACCOUNT_KIT_ACTIVITY_CONFIGURATION,
        configurationBuilder.build())
    startActivityForResult(intent, ACCOUNT_KIT_REQUEST_CODE)
  }

  /**
   * Function that handles the code return from Facebook Account Kit
   */
  override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
    super.onActivityResult(requestCode, resultCode, data)

    if (requestCode == ACCOUNT_KIT_REQUEST_CODE) {
      val loginResult: AccountKitLoginResult = data!!.getParcelableExtra(
          AccountKitLoginResult.RESULT_KEY)
      loginPresenter.onAccountKitValidateResult(loginResult)
    }
  }
}