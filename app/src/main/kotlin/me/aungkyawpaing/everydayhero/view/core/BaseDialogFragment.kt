package me.aungkyawpaing.everydayhero.view.core

import android.support.v4.app.DialogFragment
import me.aungkyawpaing.everydayhero.EveryDayHeroApplication
import me.aungkyawpaing.everydayhero.dagger.HasComponent
import me.aungkyawpaing.everydayhero.dagger.components.AppComponent


/**
 * Created by vincentpaing on 8/28/17.
 */
abstract class BaseDialogFragment : DialogFragment() {

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
