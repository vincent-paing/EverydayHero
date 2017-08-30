package com.aungkyawpaing.domain.interactor

import com.aungkyawpaing.domain.executor.PostExecutionThread
import com.aungkyawpaing.domain.executor.ThreadExecutor
import com.aungkyawpaing.domain.model.AvatarModel
import com.aungkyawpaing.domain.repository.AvatarPackRepository
import io.reactivex.Observable
import javax.inject.Inject

/**
 * Created by vincentpaing on 8/28/17.
 */
class GetAvatars @Inject constructor(threadExecutor: ThreadExecutor,
    postExecutionThread: PostExecutionThread,
    private val avatarPackRepository: AvatarPackRepository) : UseCase<List<AvatarModel>, Unit>(
    threadExecutor, postExecutionThread) {

  override fun buildUseCaseObservable(params: Unit): Observable<List<AvatarModel>> {
    return avatarPackRepository.getHeroAvatars()
  }

}