package me.aungkyawpaing.everydayhero.presenter

import com.aungkyawpaing.domain.exception.DefaultErrorBundle
import com.aungkyawpaing.domain.exception.ErrorBundle
import com.aungkyawpaing.domain.interactor.BaseObserver
import com.aungkyawpaing.domain.interactor.CompleteQuest
import com.aungkyawpaing.domain.interactor.GetQuestList
import com.aungkyawpaing.domain.model.CompleteQuestModel
import com.aungkyawpaing.domain.model.QuestModel
import me.aungkyawpaing.everydayhero.exception.ErrorMessageFactory
import me.aungkyawpaing.everydayhero.model.mapper.QuestMapper
import me.aungkyawpaing.everydayhero.view.quest.QuestView
import javax.inject.Inject

/**
 * Created by vincentpaing on 8/5/17.
 */
class QuestPresenter @Inject constructor() : BasePresenter<QuestView>() {

  private var questView: QuestView? = null
  @Inject lateinit var getQuestList: GetQuestList
  @Inject lateinit var completeQuest: CompleteQuest

  override fun init() {
  }

  override fun setView(view: QuestView) {
    this.questView = view;
  }

  fun loadQuestList() {
    getQuestList.execute(QuestObserver(), Unit)
  }

  fun completeQuest(questID: Int) {
    completeQuest.execute(CompleteQuestObserver(questID), CompleteQuest.Params(questID))
  }

  private fun renderQuestList(questList: List<QuestModel>) {
    questView?.showQuests(QuestMapper.transform(questList))
  }

  override fun resume() {
  }

  override fun pause() {
  }

  override fun destroy() {
    getQuestList.dispose()
    completeQuest.dispose()
    this.questView = null
  }

  fun showViewLoading() {
    this.questView?.showQuestLoading()
  }

  fun hideViewLoading() {
    this.questView?.hideQuestLoading()
  }

  fun showViewRetry() {
    this.questView?.showQuestRetry()
  }

  fun hideViewRetry() {
    this.questView?.hideQuestRetry()
  }

  fun showCompleteQuestLoading(questID: Int) {
    this.questView?.showCompleteQuestLoading(questID)
  }

  fun showCompleteQuestSuccess(questID: Int) {
    this.questView?.showCompleteQuestSuccess(questID)
  }

  fun showCompleteQuestFail(questID: Int) {
    this.questView?.showCompleteQuestFail(questID)
  }

  fun shareQuest() {}


  fun showErrorMessage(errorBundle: ErrorBundle) {
    val errorMessage = ErrorMessageFactory.create(questView!!.context(), errorBundle.exception)
    questView?.showError(errorMessage)
  }

  inner class QuestObserver : BaseObserver<List<QuestModel>>() {

    override fun onStart() {
      super.onStart()
      this@QuestPresenter.showViewLoading()
      this@QuestPresenter.hideViewRetry()
    }

    override fun onNext(questList: List<QuestModel>) {
      this@QuestPresenter.hideViewLoading()
      this@QuestPresenter.renderQuestList(questList)
    }

    override fun onComplete() {
      super.onComplete()
      this@QuestPresenter.hideViewRetry()
    }

    override fun onError(e: Throwable) {
      super.onError(e)
      this@QuestPresenter.showErrorMessage(DefaultErrorBundle(e as Exception))
      this@QuestPresenter.hideViewLoading()
      this@QuestPresenter.showViewRetry()
    }

  }

  inner class CompleteQuestObserver constructor(
      val questID: Int) : BaseObserver<CompleteQuestModel>() {

    override fun onStart() {
      super.onStart()
      this@QuestPresenter.showCompleteQuestLoading(this.questID)
    }

    override fun onNext(t: CompleteQuestModel) {
      super.onNext(t)
      this@QuestPresenter.showCompleteQuestSuccess(questID)
      this@QuestPresenter.questView?.onQuestComplete()
    }

    override fun onComplete() {
      super.onComplete()
    }

    override fun onError(e: Throwable) {
      super.onError(e)
      this@QuestPresenter.showErrorMessage(DefaultErrorBundle(e as Exception))
      this@QuestPresenter.showCompleteQuestFail(this.questID)
    }

  }
}