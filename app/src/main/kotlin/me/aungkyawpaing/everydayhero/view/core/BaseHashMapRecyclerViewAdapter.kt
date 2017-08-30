package me.aungkyawpaing.everydayhero.view.core;

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import java.util.LinkedHashMap

/**
 * Created by vincentpaing on 8/16/17.
 */

abstract class BaseHashMapRecyclerViewAdapter<E : BaseHashMapRecyclerViewAdapter.MappableItem, T : BaseViewHolder<E>> protected constructor(
    context: Context) : RecyclerView.Adapter<T>() {

  protected val layoutInflater: LayoutInflater
  protected var itemHashMap: LinkedHashMap<String, E>
  var onItemClick: ((E, Int) -> Unit)? = null

  init {
    this.itemHashMap = LinkedHashMap<String, E>()
    layoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
  }

  override fun onBindViewHolder(holder: T, position: Int) {
    holder.bind(getItem(position))
  }

  abstract override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): T

  fun getItem(index: Int): E {
    return itemHashMap.values.elementAt(index)
  }

  fun getItem(key: String): E {
    return itemHashMap[key] as E
  }

  fun setItem(item: E) {
    itemHashMap.set(item.getID.invoke(), item)
    notifyDataSetChanged()
  }

  var items: Collection<E>
    get() = itemHashMap.values
    set(itemCollection) {
      itemHashMap.clear()
      for (e in itemCollection) {
        itemHashMap.put(e.getID.invoke(), e)
      }
      notifyDataSetChanged()
    }

  override fun getItemCount(): Int {
    return itemHashMap.values.size
  }

  fun addorUpdateItems(itemCollection: Collection<E>) {
    var shouldUpdate = false
    for (e in itemCollection) {
      if (itemHashMap.containsKey(e.getID.invoke())) shouldUpdate = true
      itemHashMap.put(e.getID.invoke(), e)
    }

    val start = itemHashMap.values.size - itemCollection.size
    if (shouldUpdate) {
      notifyItemRangeChanged(start, itemCollection.size)
    } else {
      notifyItemRangeInserted(start, itemCollection.size)
    }
  }

  fun addorUpdateItemsAndRefresh(itemCollection: kotlin.collections.Collection<E>) {
    var shouldUpdate = false
    for (e in itemCollection) {
      if (itemHashMap.containsKey(e.getID.invoke())) shouldUpdate = true
      itemHashMap.put(e.getID.invoke(), e)
    }

    notifyDataSetChanged()
  }

  fun clearItems() {
    itemHashMap.clear()
    notifyDataSetChanged()
  }

  fun addItem(itemCollection: kotlin.collections.Collection<E>) {
    for (e in itemCollection) {
      itemHashMap.put(e.getID.invoke(), e)
    }

    val start = itemHashMap.values.size - itemCollection.size
    notifyItemRangeChanged(start, itemCollection.size)
  }

  /**
   * Created by vincentpaing on 11/27/16.
   */

  interface MappableItem {

    val getID: (() -> String)
  }
}