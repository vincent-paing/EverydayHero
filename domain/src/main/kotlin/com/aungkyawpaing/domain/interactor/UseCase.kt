package com.aungkyawpaing.domain.interactor

import com.aungkyawpaing.domain.executor.PostExecutionThread
import com.aungkyawpaing.domain.executor.ThreadExecutor
import io.reactivex.Observable
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers

/**
 * Created by vincentpaing on 7/30/17.
 */
abstract class UseCase<T, Params> internal constructor(private val threadExecutor: ThreadExecutor,
    private val postExecutionThread: PostExecutionThread) {

  private val disposables: CompositeDisposable = CompositeDisposable()

  /**
   * Builds an [Observable] which will be used when executing the current [UseCase].
   */
  internal abstract fun buildUseCaseObservable(params: Params): Observable<T>

  /**
   * Executes the current use case.

   * @param observer [DisposableObserver] which will be listening to the observable build
   * * by [.buildUseCaseObservable] ()} method.
   * *
   * @param params Parameters (Optional) used to build/execute this use case.
   */
  fun execute(observer: DisposableObserver<T>, params: Params) {
    val observable = this.buildUseCaseObservable(params)
        .subscribeOn(Schedulers.from(threadExecutor))
        .observeOn(postExecutionThread.scheduler)
    addDisposable(observable.subscribeWith(observer))
  }

  /**
   * Dispose from current [CompositeDisposable].
   */
  fun dispose() {
    if (!disposables.isDisposed) {
      disposables.dispose()
    }
  }

  /**
   * Dispose from current [CompositeDisposable].
   */
  private fun addDisposable(disposable: Disposable?) {
    if (disposable != null) {
      disposables.add(disposable)
    }
  }
}