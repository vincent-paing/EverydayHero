package me.aungkyawpaing.everydayhero.presenter

import com.aungkyawpaing.domain.exception.DefaultErrorBundle
import com.aungkyawpaing.domain.exception.ErrorBundle
import com.aungkyawpaing.domain.interactor.BaseObserver
import com.aungkyawpaing.domain.interactor.Login
import com.aungkyawpaing.domain.model.LoginModel
import com.aungkyawpaing.domain.validation.Validator
import com.facebook.accountkit.AccountKit
import com.facebook.accountkit.AccountKitLoginResult
import me.aungkyawpaing.everydayhero.exception.ErrorMessageFactory
import me.aungkyawpaing.everydayhero.view.login.LoginView
import timber.log.Timber
import javax.inject.Inject

/**
 * Created by vincentpaing on 7/30/17.
 */
public class LoginPresenter @Inject constructor() : LoadingPresenter<LoginView>() {

  private var loginView: LoginView? = null
  @Inject lateinit var login: Login

  override fun init() {

  }

  override fun setView(loginView: LoginView) {
    this.loginView = loginView
  }

  private fun checkLogin(loginModel: LoginModel) {
    if (loginModel.isFIrstTimeLoggingIn)
      loginView?.navigateToHeroNameView()
    else
      loginView?.navigateToMainView()

  }

  fun verifyPhoneNumber() {
    loginView?.showPhoneNumberValidation()
  }

  fun onAccountKitValidateResult(loginResult: AccountKitLoginResult) {

    if (loginResult.error != null) {
      Timber.e(loginResult.error.toString())
      val toastMessage: String = loginResult.error!!.errorType.message
      loginView?.showError(toastMessage)
    } else if (loginResult.wasCancelled()) {
      loginView?.showError("Verification Cancelled")
    } else {
      if (loginResult.authorizationCode != null) {
        val authCode = loginResult.authorizationCode
        Timber.i(authCode!!)
        login(authCode!!)
      }
    }
  }

  fun login(authCode: String) {
    login.execute(LoginObserver(), Login.Params(authCode))
  }

  override fun showViewLoading() {
    loginView?.showLoading()
  }

  override fun hideViewLoading() {
    loginView?.hideLoading()
  }

  override fun showViewRetry() {
    loginView?.showRetry()
  }

  override fun hideViewRetry() {
    loginView?.hideLoading()
  }

  override fun showErrorMessage(errorBundle: ErrorBundle) {
    val errorMessage = ErrorMessageFactory.create(loginView!!.context(), errorBundle.exception)
    loginView?.showError(errorMessage)
  }

  override fun resume() {

  }

  override fun pause() {

  }

  override fun destroy() {
    this.login.dispose()
    this.loginView = null
  }

  private inner class LoginObserver : BaseObserver<LoginModel>() {

    override fun onStart() {
      super.onStart()
      this@LoginPresenter.showViewLoading()
    }

    override fun onNext(loginModel: LoginModel) {
      super.onNext(loginModel)
      this@LoginPresenter.hideViewRetry()
      this@LoginPresenter.hideViewLoading()
      this@LoginPresenter.checkLogin(loginModel)
    }

    override fun onComplete() {
      super.onComplete()
      this@LoginPresenter.hideViewLoading()
    }

    override fun onError(e: Throwable) {
      super.onError(e)
      this@LoginPresenter.showErrorMessage(DefaultErrorBundle(e as Exception))
      this@LoginPresenter.hideViewLoading()
      this@LoginPresenter.showViewRetry()
    }

  }


}
