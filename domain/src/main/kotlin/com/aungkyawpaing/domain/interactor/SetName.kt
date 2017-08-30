package com.aungkyawpaing.domain.interactor

import com.aungkyawpaing.domain.executor.PostExecutionThread
import com.aungkyawpaing.domain.executor.ThreadExecutor
import com.aungkyawpaing.domain.interactor.SetName.Params
import com.aungkyawpaing.domain.repository.HeroRepository
import com.aungkyawpaing.domain.validation.Validator
import io.reactivex.Observable
import javax.inject.Inject

/**
 * Created by vincentpaing on 8/27/17.
 */
class SetName @Inject constructor(threadExecutor: ThreadExecutor,
    postExecutionThread: PostExecutionThread,
    val heroRepository: HeroRepository) : UseCase<Unit, Params>(threadExecutor,
    postExecutionThread) {


  override fun buildUseCaseObservable(params: Params): Observable<Unit> {
    val validationResult = Validator.validateUserName(params.name)

    if (!validationResult.isValid) {
      return Observable.error(Exception(validationResult.message))
    }
    return heroRepository.setName(params.name)
  }

  data class Params(val name: String)
}