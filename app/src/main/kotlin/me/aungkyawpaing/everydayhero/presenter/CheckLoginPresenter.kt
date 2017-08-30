package me.aungkyawpaing.everydayhero.presenter

import android.util.Log
import com.aungkyawpaing.domain.exception.DefaultErrorBundle
import com.aungkyawpaing.domain.exception.ErrorBundle
import com.aungkyawpaing.domain.interactor.BaseObserver
import com.aungkyawpaing.domain.interactor.CheckLoginStatus
import com.aungkyawpaing.domain.model.LoginStatusModel
import com.facebook.accountkit.internal.LoginStatus
import me.aungkyawpaing.everydayhero.exception.ErrorMessageFactory
import me.aungkyawpaing.everydayhero.view.main.CheckLoginView
import timber.log.Timber
import javax.inject.Inject

/**
 * Created by vincentpaing on 8/8/17.
 */
class CheckLoginPresenter @Inject constructor() : LoadingPresenter<CheckLoginView>() {

  var checkLoginView: CheckLoginView? = null
  @Inject lateinit var checkLoginStatus: CheckLoginStatus

  override fun init() {
    loadLoginStatus()
  }

  fun loadLoginStatus() {
    checkLoginStatus.execute(CheckLoginObserver(), Unit)
  }

  fun renderLoginStatus(loginStatus: LoginStatusModel) {
    with(loginStatus) {
      if (isLoggedIn && isFirstTime) {
        checkLoginView?.showFirstTime()
      } else if (isLoggedIn) {
        checkLoginView?.showLoggedIn()
      } else {
        checkLoginView?.showNotLoggedIn()
      }
    }
  }


  override fun setView(view: CheckLoginView) {
    this.checkLoginView = view
  }

  override fun resume() {
  }

  override fun showViewLoading() {
    this.checkLoginView?.showLoading()
  }

  override fun hideViewLoading() {
    this.checkLoginView?.hideLoading()
  }

  override fun showViewRetry() {
    this.checkLoginView?.showRetry()
  }

  override fun hideViewRetry() {
    this.checkLoginView?.hideRetry()
  }

  override fun showErrorMessage(errorBundle: ErrorBundle) {
    val errorMessage = ErrorMessageFactory.create(checkLoginView!!.context(), errorBundle.exception)
    this.checkLoginView?.showError(errorMessage)
  }

  override fun pause() {
  }

  override fun destroy() {
    this.checkLoginStatus.dispose()
    this.checkLoginView = null
  }

  inner class CheckLoginObserver : BaseObserver<LoginStatusModel>() {

    override fun onNext(value: LoginStatusModel) {
      super.onNext(value)
      this@CheckLoginPresenter.renderLoginStatus(value)
    }

    override fun onError(e: Throwable) {
      super.onError(e)
      this@CheckLoginPresenter.showErrorMessage(DefaultErrorBundle(e as Exception))
    }

  }


}