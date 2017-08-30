package me.aungkyawpaing.everydayhero.presenter

import com.aungkyawpaing.domain.exception.DefaultErrorBundle
import com.aungkyawpaing.domain.exception.ErrorBundle
import com.aungkyawpaing.domain.interactor.BaseObserver
import com.aungkyawpaing.domain.interactor.SetName
import me.aungkyawpaing.everydayhero.exception.ErrorMessageFactory
import me.aungkyawpaing.everydayhero.view.updatename.UpdateNameView
import javax.inject.Inject

/**
 * Created by vincentpaing on 8/27/17.
 */
class UpdateNamePresenter @Inject constructor() : LoadingPresenter<UpdateNameView>() {

  var updateNameView: UpdateNameView? = null
  @Inject lateinit var updateName: SetName

  override fun init() {
  }

  override fun setView(view: UpdateNameView) {
    this.updateNameView = view
  }

  fun updateName(name: String) {
    updateName.execute(UpdateNameObserver(), SetName.Params(name))
  }

  override fun resume() {
  }

  override fun showViewLoading() {
    updateNameView?.showLoading()
  }

  override fun hideViewLoading() {
    updateNameView?.hideLoading()
  }

  override fun showViewRetry() {
    updateNameView?.showRetry()
  }

  override fun hideViewRetry() {
    updateNameView?.hideRetry()
  }

  override fun showErrorMessage(errorBundle: ErrorBundle) {
    val errorMessage = ErrorMessageFactory.create(updateNameView!!.context(), errorBundle.exception)
    updateNameView?.showError(errorMessage)
  }

  override fun pause() {
  }

  private fun renderSuccess() {
    updateNameView?.showUpdateSuccess()
  }

  override fun destroy() {
    updateName.dispose()
    updateNameView = null
  }

  inner class UpdateNameObserver : BaseObserver<Unit>() {

    override fun onStart() {
      super.onStart()
      this@UpdateNamePresenter.showViewLoading()
      this@UpdateNamePresenter.hideViewRetry()
    }

    override fun onNext(unit: Unit) {
      super.onNext(unit)
      this@UpdateNamePresenter.hideViewLoading()
      this@UpdateNamePresenter.renderSuccess()
    }

    override fun onComplete() {
      super.onComplete()
      this@UpdateNamePresenter.hideViewRetry()
    }

    override fun onError(e: Throwable) {
      super.onError(e)
      this@UpdateNamePresenter.showErrorMessage(DefaultErrorBundle(e as Exception))
      this@UpdateNamePresenter.hideViewLoading()
      this@UpdateNamePresenter.showViewRetry()
    }

  }

}