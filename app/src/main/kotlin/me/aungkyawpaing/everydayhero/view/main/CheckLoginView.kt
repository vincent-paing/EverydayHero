package me.aungkyawpaing.everydayhero.view.main

import me.aungkyawpaing.everydayhero.view.core.LoadingView

/**
 * Created by vincentpaing on 8/8/17.
 */
interface CheckLoginView : LoadingView {

  fun showLoggedIn()

  fun showNotLoggedIn()

  fun showFirstTime()

}