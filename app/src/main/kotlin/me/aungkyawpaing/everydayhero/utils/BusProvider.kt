package me.aungkyawpaing.everydayhero.utils

import com.hwangjr.rxbus.Bus

/**
 * Created by vincentpaing on 8/19/17.
 */
object BusProvider {
  private val bus: Bus = Bus()

  @Synchronized
  fun get(): Bus {
    return bus
  }
}