package me.aungkyawpaing.everydayhero.components

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.util.AttributeSet
import android.view.MotionEvent
import com.cooltechworks.views.shimmer.ShimmerRecyclerView

/**
 * Created by vincentpaing on 8/22/17.
 */
class NotScrollableShimmerRecyclerView : ShimmerRecyclerView {

  constructor(context: Context) : super(context) {}

  constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {}

  constructor(context: Context, attrs: AttributeSet, defStyle: Int) : super(context, attrs,
      defStyle) {
  }

  override fun onInterceptTouchEvent(e: MotionEvent): Boolean {
    return false
  }

  override fun onTouchEvent(e: MotionEvent): Boolean {
    return false
  }
}