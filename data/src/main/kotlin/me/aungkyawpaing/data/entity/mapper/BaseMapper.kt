package me.aungkyawpaing.data.entity.mapper

import java.util.ArrayList

/**
 * Created by vincentpaing on 8/1/17.
 */
abstract class BaseMapper<T, E> {

  abstract fun transform(obj: T): E

  fun transform(collection: Collection<T>): List<E> {
    val list = ArrayList<E>(collection.size)
    for (t in collection) {
      list.add(transform(t))
    }
    return list
  }
}