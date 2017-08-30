package me.aungkyawpaing.everydayhero.presenter

import com.aungkyawpaing.domain.exception.DefaultErrorBundle
import com.aungkyawpaing.domain.exception.ErrorBundle
import com.aungkyawpaing.domain.interactor.BaseObserver
import com.aungkyawpaing.domain.interactor.GetAvatars
import com.aungkyawpaing.domain.interactor.SetAvatar
import com.aungkyawpaing.domain.model.AvatarModel
import me.aungkyawpaing.everydayhero.exception.ErrorMessageFactory
import me.aungkyawpaing.everydayhero.model.mapper.AvatarMapper
import me.aungkyawpaing.everydayhero.view.avatars.AvatarsView
import javax.inject.Inject

/**
 * Created by vincentpaing on 8/28/17.
 */
class AvatarPresenter @Inject constructor() : BasePresenter<AvatarsView>() {

  var avatarsView: AvatarsView? = null
  @Inject lateinit var getAvatars: GetAvatars
  @Inject lateinit var setAvatar: SetAvatar

  override fun init() {
  }

  override fun setView(view: AvatarsView) {
    this.avatarsView = view
  }

  fun loadAvatars() {
    getAvatars.execute(GetAvatarsObserver(), Unit)
  }

  fun updateAvatar(avatarId: Int) {
    setAvatar.execute(SetAvatarObserver(), SetAvatar.Params(avatarId))
  }

  private fun renderAvatars(avatarModels: List<AvatarModel>) {
    avatarsView?.showAvatars(AvatarMapper.transform(avatarModels))
  }

  private fun renderUpdateSuccess() {
    avatarsView?.showUpdateAvatarSuccess()
  }

  fun showViewLoading() {
    avatarsView?.showAvatarsLoading()
  }

  fun hideViewLoading() {
    avatarsView?.hideAvatarsLoading()
  }

  fun showViewRetry() {
    avatarsView?.showAvatarsRetry()
  }

  fun hideViewRetry() {
    avatarsView?.hideAvatarsRetry()
  }

  fun showErrorMessage(errorBundle: ErrorBundle) {
    val errorMessage = ErrorMessageFactory.create(avatarsView!!.context(), errorBundle.exception)
    avatarsView?.showError(errorMessage)
  }

  fun selectAvatar(avatarId: String) {
    avatarsView?.showSelectAvatar(avatarId)
  }


  override fun resume() {
  }

  override fun pause() {
  }

  override fun destroy() {
    avatarsView = null
    getAvatars.dispose()
    setAvatar.dispose()
  }

  private inner class GetAvatarsObserver : BaseObserver<List<AvatarModel>>() {

    override fun onStart() {
      super.onStart()
      this@AvatarPresenter.showViewLoading()
    }

    override fun onNext(avatarModels: List<AvatarModel>) {
      super.onNext(avatarModels)
      this@AvatarPresenter.hideViewRetry()
      this@AvatarPresenter.hideViewLoading()
      this@AvatarPresenter.renderAvatars(avatarModels)
    }

    override fun onComplete() {
      super.onComplete()
      this@AvatarPresenter.hideViewLoading()
    }

    override fun onError(e: Throwable) {
      super.onError(e)
      this@AvatarPresenter.showErrorMessage(DefaultErrorBundle(e as Exception))
      this@AvatarPresenter.hideViewLoading()
      this@AvatarPresenter.showViewRetry()
    }

  }

  private inner class SetAvatarObserver : BaseObserver<Unit>() {

    override fun onStart() {
      super.onStart()
      this@AvatarPresenter.showViewLoading()
    }

    override fun onNext(unit: Unit) {
      super.onNext(unit)
      this@AvatarPresenter.hideViewRetry()
      this@AvatarPresenter.hideViewLoading()
      this@AvatarPresenter.renderUpdateSuccess()
    }

    override fun onComplete() {
      super.onComplete()
      this@AvatarPresenter.hideViewLoading()
    }

    override fun onError(e: Throwable) {
      super.onError(e)
      this@AvatarPresenter.showErrorMessage(DefaultErrorBundle(e as Exception))
      this@AvatarPresenter.hideViewLoading()
      this@AvatarPresenter.showViewRetry()
    }

  }

}