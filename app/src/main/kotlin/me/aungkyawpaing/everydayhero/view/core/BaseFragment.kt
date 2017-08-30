package me.aungkyawpaing.everydayhero.view.core

import android.os.Bundle
import android.support.v4.app.Fragment
import android.widget.Toast
import me.aungkyawpaing.everydayhero.EveryDayHeroApplication
import me.aungkyawpaing.everydayhero.dagger.HasComponent
import me.aungkyawpaing.everydayhero.dagger.components.AppComponent
import me.aungkyawpaing.everydayhero.utils.BusProvider

/**
 * Created by vincentpaing on 7/30/17.
 */
abstract class BaseFragment : Fragment() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    BusProvider.get().register(this)
  }

  override fun onDestroy() {
    super.onDestroy()
    BusProvider.get().unregister(this)
  }

  /**
   * Shows a [android.widget.Toast] message.

   * @param message An string representing a message to be shown.
   */
  protected fun showToastMessage(message: String) {
    Toast.makeText(activity, message, Toast.LENGTH_SHORT).show()
  }

  /**
   * Get the Main Application component for dependency injection.

   * @return [AppComponent]
   */
  protected val appComponent: AppComponent
    get() = (activity.application as EveryDayHeroApplication).appComponent

  /**
   * Gets a component for dependency injection by its type.
   */
  protected fun <C> getComponent(componentType: Class<C>): C {
    return componentType.cast((activity as HasComponent<C>).component)
  }
}