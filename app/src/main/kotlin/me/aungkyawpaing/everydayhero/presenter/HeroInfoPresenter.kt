package me.aungkyawpaing.everydayhero.presenter

import com.aungkyawpaing.domain.exception.DefaultErrorBundle
import com.aungkyawpaing.domain.exception.ErrorBundle
import com.aungkyawpaing.domain.interactor.BaseObserver
import com.aungkyawpaing.domain.interactor.GetHero
import com.aungkyawpaing.domain.model.HeroModel
import me.aungkyawpaing.everydayhero.exception.ErrorMessageFactory
import me.aungkyawpaing.everydayhero.model.mapper.HeroMapper
import me.aungkyawpaing.everydayhero.view.herodetail.HeroInfoView
import timber.log.Timber
import javax.inject.Inject

/**
 * Created by vincentpaing on 8/19/17.
 */
class HeroInfoPresenter @Inject constructor() : BasePresenter<HeroInfoView>() {

  var heroInfoView: HeroInfoView? = null
  @Inject lateinit var getHero: GetHero


  override fun init() {
  }

  override fun setView(view: HeroInfoView) {
    this.heroInfoView = view
  }

  override fun resume() {
  }

  override fun pause() {
  }

  override fun destroy() {
    this.getHero.dispose()
    this.heroInfoView = null
  }

  fun onQuestComplete() {
    loadHero()
  }

  fun loadHero() {
    getHero.execute(GetHeroObserver(), Unit)
  }

  fun renderHero(heroModel: HeroModel) {

    heroInfoView?.showHeroInfo(HeroMapper.transform(heroModel))
  }

  fun showViewLoading() {
    heroInfoView?.showHeroLoading()
  }

  fun hideViewLoading() {
    heroInfoView?.hideHeroLoading()
  }

  fun showViewRetry() {
    heroInfoView?.showHeroRetry()
  }

  fun hideViewRetry() {
    heroInfoView?.hideHeroRetry()
  }

  fun showErrorMessage(errorBundle: ErrorBundle) {
    val errorMessage = ErrorMessageFactory.create(heroInfoView!!.context(), errorBundle.exception)
    heroInfoView?.showError(errorMessage)
  }


  private inner class GetHeroObserver : BaseObserver<HeroModel>() {

    override fun onStart() {
      super.onStart()
      this@HeroInfoPresenter.showViewLoading()
    }

    override fun onNext(heroModel: HeroModel) {
      super.onNext(heroModel)
      Timber.i(heroModel.toString())
      this@HeroInfoPresenter.hideViewRetry()
      this@HeroInfoPresenter.hideViewLoading()
      this@HeroInfoPresenter.renderHero(heroModel)
    }

    override fun onComplete() {
      super.onComplete()
      this@HeroInfoPresenter.hideViewLoading()
    }

    override fun onError(e: Throwable) {
      super.onError(e)
      this@HeroInfoPresenter.showErrorMessage(DefaultErrorBundle(e as Exception))
      this@HeroInfoPresenter.hideViewLoading()
      this@HeroInfoPresenter.showViewRetry()
    }

  }

}
