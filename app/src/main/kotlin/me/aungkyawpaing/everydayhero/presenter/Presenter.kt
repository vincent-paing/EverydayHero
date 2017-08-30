package me.aungkyawpaing.everydayhero.presenter

/**
 * Created by vincentpaing on 7/30/17.
 */
interface Presenter {
  /**
   * Method that control the lifecycle of the view. It should be called in the view's
   * (Activity or Fragment) onResume() method.
   */
  abstract fun resume()

  /**
   * Method that control the lifecycle of the view. It should be called in the view's
   * (Activity or Fragment) onPause() method.
   */
  abstract fun pause()

  /**
   * Method that control the lifecycle of the view. It should be called in the view's
   * (Activity or Fragment) onDestroy() method.
   */
  abstract fun destroy()
}