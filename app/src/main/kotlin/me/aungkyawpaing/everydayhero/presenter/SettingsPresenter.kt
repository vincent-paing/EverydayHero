package me.aungkyawpaing.everydayhero.presenter

import me.aungkyawpaing.everydayhero.view.settings.SettingsView
import javax.inject.Inject

/**
 * Created by vincentpaing on 8/28/17.
 */
class SettingsPresenter @Inject constructor() : BasePresenter<SettingsView>() {

  var settingsView: SettingsView? = null

  override fun init() {
  }

  override fun setView(view: SettingsView) {
    this.settingsView = view
  }

  fun renderSelectAvatar() {
    settingsView?.showSelectAvatar()
  }

  override fun resume() {
  }

  override fun pause() {
  }

  override fun destroy() {
    settingsView = null
  }

}