package me.aungkyawpaing.everydayhero.exception

import android.content.Context
import me.aungkyawpaing.everydayhero.R
import timber.log.Timber
import java.io.IOException
import java.net.SocketTimeoutException
import java.net.UnknownHostException
import javax.inject.Inject

/**
 * Created by vincentpaing on 8/3/17.
 */

/**
 * Factory used to create error messages from an Exception as a condition.
 */
object ErrorMessageFactory {

  /**
   * Creates a String representing an error message.

   * @param context Context needed to retrieve string resources.
   * *
   * @param exception An exception used as a condition to retrieve the correct error message.
   * *
   * @return [String] an error message.
   */
  fun create(context: Context, exception: Exception): String {

    Timber.e(exception)

    var message = context.getString(R.string.error_generic)

    if (exception.cause is IOException) {
      val ioException = exception.cause as IOException
      if (ioException is UnknownHostException) {
        message = context.getString(R.string.error_no_connection)
      } else if (ioException is SocketTimeoutException) {
        message = context.getString(R.string.error_socket_timeout)
      } else {
        message = ioException.message
      }
    } else if (exception.message != null) {
      message = exception.message
    }

    return message
  }
}//empty