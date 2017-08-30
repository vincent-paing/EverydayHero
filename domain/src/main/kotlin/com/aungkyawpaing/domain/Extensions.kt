package com.aungkyawpaing.domain

/**
 * Created by vincentpaing on 8/24/17.
 */

inline fun consume(f: () -> Unit): Boolean {
  f()
  return true
}