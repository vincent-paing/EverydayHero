package me.aungkyawpaing.everydayhero.view.core

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.View

/**
 * Created by vincentpaing on 7/30/17.
 */
abstract class BaseViewHolder<T> protected constructor(itemView: View,
    val itemClick: ((T, Int) -> Unit)?) : RecyclerView.ViewHolder(itemView) {

  abstract fun bind(item: T)
}