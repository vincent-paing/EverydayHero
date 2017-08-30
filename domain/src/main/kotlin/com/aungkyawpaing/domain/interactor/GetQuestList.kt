package com.aungkyawpaing.domain.interactor

import com.aungkyawpaing.domain.executor.PostExecutionThread
import com.aungkyawpaing.domain.executor.ThreadExecutor
import com.aungkyawpaing.domain.model.QuestModel
import com.aungkyawpaing.domain.repository.QuestRepository
import io.reactivex.Observable
import javax.inject.Inject

/**
 * Created by vincentpaing on 8/5/17.
 */
class GetQuestList @Inject constructor(threadExecutor: ThreadExecutor,
    postExecutionThread: PostExecutionThread,
    val questRepository: QuestRepository) : UseCase<List<QuestModel>, Unit>(
    threadExecutor, postExecutionThread) {

  override fun buildUseCaseObservable(params: Unit): Observable<List<QuestModel>> {
    return questRepository.getQuests()
  }
}
