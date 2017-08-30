package me.aungkyawpaing.everydayhero.utils

import android.content.Context
import android.util.DisplayMetrics
import android.view.MenuItem
import android.view.View

/**
 * Created by vincentpaing on 7/30/17.
 */
object ViewUtils {

  fun toggle(vararg v: View) {
    for (view in v) {
      view.isEnabled = !view.isEnabled
    }
  }

  fun visible(vararg v: View) {
    for (view in v) {
      view.visibility = View.VISIBLE
    }
  }

  fun invisible(vararg v: View) {
    for (view in v) {
      view.visibility = View.INVISIBLE
    }
  }

  fun gone(vararg v: View) {
    for (view in v) {
      view.visibility = View.GONE
    }
  }


  fun swap(hide: View, show: View) {
    hide.visibility = View.INVISIBLE
    show.visibility = View.VISIBLE
  }


  /**
   * This method converts dp unit to equivalent pixels, depending on device density.

   * @param dp A value in dp (density independent pixels) unit. Which we need to convert into
   * * pixels
   * *
   * @param context Context to get resources and device specific display metrics
   * *
   * @return A float value to represent px equivalent to dp depending on device density
   */
  fun convertDpToPixel(dp: Float, context: Context): Float {
    val resources = context.resources
    val metrics = resources.displayMetrics
    val px = dp * (metrics.densityDpi.toFloat() / DisplayMetrics.DENSITY_DEFAULT)
    return px
  }

  /**
   * This method converts device specific pixels to density independent pixels.

   * @param px A value in px (pixels) unit. Which we need to convert into db
   * *
   * @param context Context to get resources and device specific display metrics
   * *
   * @return A float value to represent dp equivalent to px value
   */
  fun convertPixelsToDp(px: Float, context: Context): Float {
    val resources = context.resources
    val metrics = resources.displayMetrics
    val dp = px / (metrics.densityDpi.toFloat() / DisplayMetrics.DENSITY_DEFAULT)
    return dp
  }

  fun View.isVisible(): Boolean {
    return this.visibility == View.VISIBLE
  }
}