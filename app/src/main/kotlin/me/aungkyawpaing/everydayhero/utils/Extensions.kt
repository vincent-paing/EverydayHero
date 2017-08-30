package me.aungkyawpaing.everydayhero.utils

import android.content.Context
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Toast

/**
 * Created by vincentpaing on 8/3/17.
 */
fun View.setVisible(isVisible: Boolean) {
  if (isVisible) {
    this.visibility = View.VISIBLE
  } else {
    this.visibility = View.GONE
  }
}

fun AppCompatActivity.showShortToast(message: String) {
  Toast.makeText(applicationContext, message, Toast.LENGTH_SHORT).show()
}

fun AppCompatActivity.showLongToast(message: String) {
  Toast.makeText(applicationContext, message, Toast.LENGTH_LONG).show()
}

fun Fragment.showShortToast(message: String) {
  Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
}

fun Fragment.showLongToast(message: String) {
  Toast.makeText(context, message, Toast.LENGTH_LONG).show()
}
