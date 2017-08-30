package com.aungkyawpaing.domain.interactor

import com.aungkyawpaing.domain.executor.PostExecutionThread
import com.aungkyawpaing.domain.executor.ThreadExecutor
import com.aungkyawpaing.domain.model.LoginStatusModel
import com.aungkyawpaing.domain.repository.AuthRepository
import com.aungkyawpaing.domain.repository.HeroRepository
import io.reactivex.Observable
import javax.inject.Inject

/**
 * Created by vincentpaing on 8/6/17.
 */
class CheckLoginStatus @Inject constructor(threadExecutor: ThreadExecutor,
    postExecutionThread: PostExecutionThread,
    val authRepository: AuthRepository) : UseCase<LoginStatusModel, Unit>(threadExecutor,
    postExecutionThread) {

  override fun buildUseCaseObservable(params: Unit): Observable<LoginStatusModel> {
    return authRepository.checkLoginStatus()
  }

}