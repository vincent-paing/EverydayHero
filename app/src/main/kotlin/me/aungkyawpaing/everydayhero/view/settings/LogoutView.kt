package me.aungkyawpaing.everydayhero.view.settings

import android.content.Context

/**
 * Created by vincentpaing on 8/28/17.
 */
interface LogoutView {

  fun showLogoutSuccess()

  fun showLogoutLoading()

  fun hideLogoutLoading()

  fun showLogoutRetry()

  fun hideLogoutRetry()

  fun showError(message: String)

  fun context(): Context

}