package me.aungkyawpaing.everydayhero.components

import android.content.Context
import android.util.AttributeSet
import android.widget.FrameLayout

/**
 * Created by vincentpaing on 8/28/17.
 */
class SquareFrameLayout : FrameLayout {

  constructor(context: Context) : super(context) {

  }

  constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {

  }

  constructor(context: Context, attrs: AttributeSet, defStyle: Int) : super(context, attrs,
      defStyle) {

  }

  override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
    super.onMeasure(widthMeasureSpec, heightMeasureSpec)
    setMeasuredDimension(measuredWidth, measuredWidth)
  }
}