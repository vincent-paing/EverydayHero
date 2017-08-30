package com.aungkyawpaing.domain.interactor

import com.aungkyawpaing.domain.executor.PostExecutionThread
import com.aungkyawpaing.domain.executor.ThreadExecutor
import com.aungkyawpaing.domain.repository.AuthRepository
import io.reactivex.Observable
import javax.inject.Inject

/**
 * Created by vincentpaing on 8/28/17.
 */
class Logout @Inject constructor(threadExecutor: ThreadExecutor,
    postExecutionThread: PostExecutionThread,
    val authRepository: AuthRepository) : UseCase<Unit, Unit>(threadExecutor,
    postExecutionThread) {

  override fun buildUseCaseObservable(params: Unit): Observable<Unit> {
    return authRepository.logout()
  }


}