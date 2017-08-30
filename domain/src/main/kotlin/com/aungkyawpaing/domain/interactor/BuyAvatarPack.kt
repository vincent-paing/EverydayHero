package com.aungkyawpaing.domain.interactor

import com.aungkyawpaing.domain.executor.PostExecutionThread
import com.aungkyawpaing.domain.executor.ThreadExecutor
import com.aungkyawpaing.domain.model.BuyAvatarPackModel
import com.aungkyawpaing.domain.repository.AvatarPackRepository
import io.reactivex.Observable
import javax.inject.Inject

/**
 * Created by vincentpaing on 8/26/17.
 */
class BuyAvatarPack @Inject constructor(threadExecutor: ThreadExecutor,
    postExecutionThread: PostExecutionThread,
    private val avatarPackRepository: AvatarPackRepository) : UseCase<BuyAvatarPackModel, BuyAvatarPack.Params>(
    threadExecutor, postExecutionThread) {

  override fun buildUseCaseObservable(params: Params): Observable<BuyAvatarPackModel> {
    return avatarPackRepository.buyAvatarPack(params.packId)
  }

  data class Params(
      val packId: Int
  )

}