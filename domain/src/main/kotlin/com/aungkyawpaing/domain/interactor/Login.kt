package com.aungkyawpaing.domain.interactor

import com.aungkyawpaing.domain.executor.PostExecutionThread
import com.aungkyawpaing.domain.executor.ThreadExecutor
import com.aungkyawpaing.domain.model.HeroModel
import com.aungkyawpaing.domain.model.LoginModel
import com.aungkyawpaing.domain.repository.AuthRepository
import com.aungkyawpaing.domain.repository.HeroRepository
import com.aungkyawpaing.domain.validation.ValidationResult
import com.aungkyawpaing.domain.validation.Validator
import io.reactivex.Observable
import javax.inject.Inject

/**
 * Created by vincentpaing on 8/1/17.
 */
class Login @Inject constructor(threadExecutor: ThreadExecutor,
    postExecutionThread: PostExecutionThread,
    val authRepository: AuthRepository) : UseCase<LoginModel, Login.Params>(threadExecutor,
    postExecutionThread) {

  override fun buildUseCaseObservable(params: Params): Observable<LoginModel> {

    return authRepository.login(params.authCode)
  }

  data class Params(val authCode: String)
}