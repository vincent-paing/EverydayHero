package com.aungkyawpaing.domain.interactor

import io.reactivex.annotations.NonNull
import io.reactivex.observers.DisposableObserver

/**
 * Created by vincentpaing on 8/1/17.
 */
abstract class BaseObserver<T> : DisposableObserver<T>() {

  override fun onStart() {
    super.onStart()
  }

  override fun onNext(@NonNull t: T) {

  }

  override fun onError(@NonNull e: Throwable) {

  }

  override fun onComplete() {

  }
}
