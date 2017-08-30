package me.aungkyawpaing.everydayhero.presenter

import com.aungkyawpaing.domain.exception.ErrorBundle
import me.aungkyawpaing.everydayhero.view.core.LoadingView

/**
 * Created by vincentpaing on 8/3/17.
 */
abstract class LoadingPresenter<T : LoadingView> : BasePresenter<T>() {

  abstract fun showViewLoading()

  abstract fun hideViewLoading()

  abstract fun showViewRetry()

  abstract fun hideViewRetry()

  abstract fun showErrorMessage(errorBundle: ErrorBundle)


}