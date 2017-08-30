package com.aungkyawpaing.domain.interactor

import com.aungkyawpaing.domain.executor.PostExecutionThread
import com.aungkyawpaing.domain.executor.ThreadExecutor
import com.aungkyawpaing.domain.model.CompleteQuestModel
import com.aungkyawpaing.domain.repository.QuestRepository
import io.reactivex.Observable
import javax.inject.Inject

/**
 * Created by vincentpaing on 8/16/17.
 */
class CompleteQuest @Inject constructor(threadExecutor: ThreadExecutor,
    postExecutionThread: PostExecutionThread,
    val questRepository: QuestRepository) : UseCase<CompleteQuestModel, CompleteQuest.Params>(
    threadExecutor,
    postExecutionThread) {


  override fun buildUseCaseObservable(params: Params): Observable<CompleteQuestModel> {
    return questRepository.completeQuest(params.questId)
  }


  data class Params(val questId: Int)
}