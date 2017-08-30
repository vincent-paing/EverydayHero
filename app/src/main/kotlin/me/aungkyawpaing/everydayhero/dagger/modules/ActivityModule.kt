package me.aungkyawpaing.everydayhero.dagger.modules

import android.support.v7.app.AppCompatActivity
import dagger.Module
import dagger.Provides

/**
 * Created by vincentpaing on 7/30/17.
 */

/**
 * A module to wrap the Activity state and expose it to the graph.
 */
@Module open class ActivityModule(private val activity: AppCompatActivity) {

  /**
   * Expose the activity to dependents in the graph.
   */
  @Provides internal fun activity(): AppCompatActivity {
    return this.activity
  }
}