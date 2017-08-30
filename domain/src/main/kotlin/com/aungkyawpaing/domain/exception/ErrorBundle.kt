package com.aungkyawpaing.domain.exception

/**
 * Created by vincentpaing on 8/3/17.
 */
interface ErrorBundle {
  val exception: Exception

  val errorMessage: String
}
