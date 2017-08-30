package me.aungkyawpaing.everydayhero.presenter

import com.aungkyawpaing.domain.exception.DefaultErrorBundle
import com.aungkyawpaing.domain.exception.ErrorBundle
import com.aungkyawpaing.domain.interactor.BaseObserver
import com.aungkyawpaing.domain.interactor.Logout
import me.aungkyawpaing.everydayhero.exception.ErrorMessageFactory
import me.aungkyawpaing.everydayhero.view.settings.LogoutView
import javax.inject.Inject

/**
 * Created by vincentpaing on 8/28/17.
 */
class LogoutPresenter @Inject constructor() : BasePresenter<LogoutView>() {

  private var logoutView: LogoutView? = null
  @Inject lateinit var logout: Logout


  override fun init() {
  }

  override fun setView(view: LogoutView) {
    this.logoutView = view
  }

  fun logout() {
    logout.execute(LogoutObserver(), Unit)
  }

  private fun showLogout() {
    logoutView?.showLogoutSuccess()
  }

  fun showViewLoading() {
    logoutView?.showLogoutLoading()
  }

  fun hideViewLoading() {
    logoutView?.hideLogoutLoading()
  }

  fun showViewRetry() {
    logoutView?.showLogoutRetry()
  }

  fun hideViewRetry() {
    logoutView?.hideLogoutRetry()
  }

  fun showErrorMessage(errorBundle: ErrorBundle) {
    val errorMessage = ErrorMessageFactory.create(logoutView!!.context(), errorBundle.exception)
    logoutView?.showError(errorMessage)
  }


  override fun resume() {
  }

  override fun pause() {
  }

  override fun destroy() {
    logoutView = null
    logout.dispose()
  }

  private inner class LogoutObserver : BaseObserver<Unit>() {

    override fun onStart() {
      super.onStart()
      this@LogoutPresenter.showViewLoading()
    }

    override fun onNext(unit: Unit) {
      super.onNext(unit)
      this@LogoutPresenter.hideViewRetry()
      this@LogoutPresenter.hideViewLoading()
      this@LogoutPresenter.showLogout()
    }

    override fun onComplete() {
      super.onComplete()
      this@LogoutPresenter.hideViewLoading()
    }

    override fun onError(e: Throwable) {
      super.onError(e)
      this@LogoutPresenter.showErrorMessage(DefaultErrorBundle(e as Exception))
      this@LogoutPresenter.hideViewLoading()
      this@LogoutPresenter.showViewRetry()
    }

  }


}