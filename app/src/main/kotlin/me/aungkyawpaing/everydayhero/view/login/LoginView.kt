package me.aungkyawpaing.everydayhero.view.login

import android.content.Context
import me.aungkyawpaing.everydayhero.model.Hero
import me.aungkyawpaing.everydayhero.view.core.LoadingView

/**
 * Created by vincentpaing on 7/30/17.
 */
interface LoginView : LoadingView {

  fun navigateToMainView()

  fun navigateToHeroNameView()

  fun showPhoneNumberValidation()

}
