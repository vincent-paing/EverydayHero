package me.aungkyawpaing.everydayhero.view.core

import android.content.Context

/**
 * Created by vincentpaing on 7/30/17.
 */
interface LoadingView {

  /**
   * Show a view with a progress bar indicating a loading process.
   */
  fun showLoading()

  /**
   * Hide a loading view.
   */
  fun hideLoading()

  /**
   * Show a retry view in case of an error when retrieving data.
   */
  fun showRetry()

  /**
   * Hide a retry view shown if there was an error when retrieving data.
   */
  fun hideRetry()

  /**
   * Show an error message

   * @param message A string representing an error.
   */
  fun showError(message: String)

  /**
   * Get a [android.content.Context].
   */
  fun context(): Context
}
