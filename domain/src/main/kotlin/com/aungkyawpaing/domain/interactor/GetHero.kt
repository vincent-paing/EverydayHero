package com.aungkyawpaing.domain.interactor

import com.aungkyawpaing.domain.executor.PostExecutionThread
import com.aungkyawpaing.domain.executor.ThreadExecutor
import com.aungkyawpaing.domain.model.HeroModel
import com.aungkyawpaing.domain.repository.HeroRepository
import io.reactivex.Observable
import javax.inject.Inject

/**
 * Created by vincentpaing on 8/20/17.
 */
class GetHero @Inject constructor(threadExecutor: ThreadExecutor,
    postExecutionThread: PostExecutionThread,
    val heroRepository: HeroRepository) : UseCase<HeroModel, Unit>(threadExecutor,
    postExecutionThread) {


  override fun buildUseCaseObservable(params: Unit): Observable<HeroModel> {
    return heroRepository.getHero()
  }
}