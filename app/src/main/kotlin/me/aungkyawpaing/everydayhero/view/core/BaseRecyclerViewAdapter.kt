package me.aungkyawpaing.everydayhero.view.core

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import me.aungkyawpaing.everydayhero.model.Quest
import java.util.ArrayList

/**
 * Created by vincentpaing on 7/30/17.
 */
abstract class BaseRecyclerViewAdapter<E, T : BaseViewHolder<E>> protected constructor(
    context: Context) : RecyclerView.Adapter<T>() {

  protected val layoutInflater: LayoutInflater
  protected var itemList: MutableList<E>
  var onItemClick: ((E, Int) -> Unit)? = null

  init {
    this.itemList = ArrayList<E>()
    layoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
  }

  abstract override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): T

  override fun onBindViewHolder(holder: T, position: Int) {
    holder.bind(itemList[position])
  }

  override fun getItemCount(): Int {
    return itemList.size
  }

  val items: List<E>
    get() = itemList

  fun getItem(position: Int): E {
    return itemList[position]
  }

  fun clear() {
    this.itemList.clear()
    notifyDataSetChanged()
  }

  fun setItem(position: Int, item: E) {
    this.itemList.set(position, item)
    notifyItemChanged(position)
  }


  fun setItems(itemList: Collection<E>) {
    this.itemList.clear()
    this.itemList.addAll(itemList)
    notifyDataSetChanged()
  }

  fun addItem(item: E) {
    this.itemList.add(item)
    notifyItemInserted(itemCount - 1)
  }

  fun addItemList(itemList: List<E>?) {
    if (itemList != null) {
      val start = itemCount - 1
      this.itemList.addAll(itemList)
      notifyItemRangeInserted(start, itemList.size)
    }
  }

  fun updateItemList(itemList: List<E>) {
    val start = this.itemList.size - itemList.size
    this.itemList = this.itemList.subList(0, start)
    this.itemList.addAll(itemList)
    notifyItemRangeChanged(start, itemList.size)
  }
}