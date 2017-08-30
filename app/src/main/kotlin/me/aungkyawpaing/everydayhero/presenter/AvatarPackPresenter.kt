package me.aungkyawpaing.everydayhero.presenter

import com.aungkyawpaing.domain.exception.DefaultErrorBundle
import com.aungkyawpaing.domain.exception.ErrorBundle
import com.aungkyawpaing.domain.interactor.BaseObserver
import com.aungkyawpaing.domain.interactor.BuyAvatarPack
import com.aungkyawpaing.domain.interactor.GetAvatarPacks
import com.aungkyawpaing.domain.interactor.GetHero
import com.aungkyawpaing.domain.model.AvatarPackModel
import com.aungkyawpaing.domain.model.BuyAvatarPackModel
import me.aungkyawpaing.everydayhero.exception.ErrorMessageFactory
import me.aungkyawpaing.everydayhero.model.mapper.AvatarPackMapper
import me.aungkyawpaing.everydayhero.model.mapper.BuyAvatarPackMapper
import me.aungkyawpaing.everydayhero.view.avatarpack.AvatarPackView
import timber.log.Timber
import javax.inject.Inject

/**
 * Created by vincentpaing on 8/24/17.
 */
class AvatarPackPresenter @Inject constructor() : LoadingPresenter<AvatarPackView>() {

  private var avatarPackView: AvatarPackView? = null
  @Inject lateinit var getAvatarPacks: GetAvatarPacks
  @Inject lateinit var buyAvatarPack: BuyAvatarPack

  override fun init() {
  }

  override fun setView(view: AvatarPackView) {
    this.avatarPackView = view
  }

  fun loadAvatarPacks() {
    getAvatarPacks.execute(AvatarPackObserver(), Unit)
  }

  fun buyAvatarPack(packId: Int) {
    buyAvatarPack.execute(BuyAvatarPackObserver(), BuyAvatarPack.Params(packId))
  }


  override fun resume() {
  }

  override fun showViewLoading() {
    avatarPackView?.showLoading()
  }

  override fun hideViewLoading() {
    avatarPackView?.hideLoading()
  }

  override fun showViewRetry() {
    avatarPackView?.showRetry()
  }

  override fun hideViewRetry() {
    avatarPackView?.hideRetry()
  }

  fun showBuyAvatarSuccess(buyAvatarPackModel: BuyAvatarPackModel) {
    avatarPackView?.onBuyAvatarPackSuccess(BuyAvatarPackMapper.transform(buyAvatarPackModel))
  }

  fun showBuyAvatarPackLoading() {
    avatarPackView?.showBuyAvatarPackLoading()
  }

  fun hideBuyAvatarLoading() {
    avatarPackView?.hideBuyAvatarPackLoading()
  }


  override fun showErrorMessage(errorBundle: ErrorBundle) {
    Timber.i(errorBundle.exception)
    val errorMessage = ErrorMessageFactory.create(avatarPackView!!.context(), errorBundle.exception)
    avatarPackView?.showError(errorMessage)
  }

  private fun renderAvatarPacks(avatarPacks: List<AvatarPackModel>) {
    avatarPackView?.showAvatarPacks(AvatarPackMapper.transform(avatarPacks))
  }

  override fun pause() {
  }

  override fun destroy() {
    getAvatarPacks.dispose()
    avatarPackView = null
  }

  inner class AvatarPackObserver : BaseObserver<List<AvatarPackModel>>() {

    override fun onStart() {
      super.onStart()
      this@AvatarPackPresenter.showViewLoading()
      this@AvatarPackPresenter.hideViewRetry()
    }

    override fun onNext(avatarPacks: List<AvatarPackModel>) {
      this@AvatarPackPresenter.hideViewLoading()
      this@AvatarPackPresenter.renderAvatarPacks(avatarPacks)
    }

    override fun onComplete() {
      super.onComplete()
      this@AvatarPackPresenter.hideViewRetry()
    }

    override fun onError(e: Throwable) {
      super.onError(e)
      this@AvatarPackPresenter.showErrorMessage(DefaultErrorBundle(e as Exception))
      this@AvatarPackPresenter.hideViewLoading()
      this@AvatarPackPresenter.showViewRetry()
    }
  }

  inner class BuyAvatarPackObserver : BaseObserver<BuyAvatarPackModel>() {

    override fun onStart() {
      super.onStart()
      this@AvatarPackPresenter.showBuyAvatarPackLoading()
    }

    override fun onNext(buyavatarPackModel: BuyAvatarPackModel) {
      this@AvatarPackPresenter.hideViewLoading()
      this@AvatarPackPresenter.showBuyAvatarSuccess(buyavatarPackModel)
    }

    override fun onComplete() {
      super.onComplete()
    }

    override fun onError(e: Throwable) {
      super.onError(e)
      this@AvatarPackPresenter.showErrorMessage(DefaultErrorBundle(e as Exception))
      this@AvatarPackPresenter.hideBuyAvatarLoading()
    }
  }

}