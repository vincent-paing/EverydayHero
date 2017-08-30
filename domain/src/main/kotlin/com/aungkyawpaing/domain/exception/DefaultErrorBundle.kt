package com.aungkyawpaing.domain.exception

/**
 * Created by vincentpaing on 8/4/17.
 */
class DefaultErrorBundle(override val exception: Exception) : ErrorBundle {

  override val errorMessage: String
    get() = this.exception.message ?: DEFAULT_ERROR_MSG

  companion object {

    private val DEFAULT_ERROR_MSG = "Unknown error"
  }
}