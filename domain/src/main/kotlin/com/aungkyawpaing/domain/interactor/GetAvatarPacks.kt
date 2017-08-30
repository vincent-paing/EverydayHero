package com.aungkyawpaing.domain.interactor

import com.aungkyawpaing.domain.executor.PostExecutionThread
import com.aungkyawpaing.domain.executor.ThreadExecutor
import com.aungkyawpaing.domain.model.AvatarPackModel
import com.aungkyawpaing.domain.repository.AvatarPackRepository
import io.reactivex.Observable
import javax.inject.Inject

/**
 * Created by vincentpaing on 8/24/17.
 */
class GetAvatarPacks @Inject constructor(threadExecutor: ThreadExecutor,
    postExecutionThread: PostExecutionThread,
    private val avatarPackRepository: AvatarPackRepository) : UseCase<List<AvatarPackModel>, Unit>(
    threadExecutor, postExecutionThread) {

  override fun buildUseCaseObservable(params: Unit): Observable<List<AvatarPackModel>> {
    return avatarPackRepository.getShopAvatarPacks()
  }

}