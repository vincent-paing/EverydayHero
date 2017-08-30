package me.aungkyawpaing.everydayhero.dagger.modules

import android.support.v4.app.Fragment
import dagger.Module
import dagger.Provides

/**
 * Created by vincentpaing on 8/5/17.
 */
/**
 * A module to wrap the Fragment state and expose it to the graph.
 */

@Module open class FragmentModule(private val fragment: Fragment) {

  /**
   * Expose the fragment to dependents in the graph.
   */
  @Provides internal fun fragment(): Fragment {
    return this.fragment
  }
}
