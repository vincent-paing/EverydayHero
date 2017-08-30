package me.aungkyawpaing.everydayhero.view.core

import android.os.Bundle
import android.support.annotation.LayoutRes
import android.support.annotation.StringRes
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.MenuItem
import butterknife.bindOptionalView
import butterknife.bindView
import me.aungkyawpaing.everydayhero.EveryDayHeroApplication
import me.aungkyawpaing.everydayhero.R
import me.aungkyawpaing.everydayhero.dagger.components.AppComponent
import me.aungkyawpaing.everydayhero.utils.BusProvider

/**
 * Created by vincentpaing on 7/30/17.
 */
abstract class BaseActivity : AppCompatActivity() {

  val toolbar: Toolbar? by bindOptionalView(R.id.toolbar)

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(layoutResId)
    BusProvider.get().register(this)

    if (toolbar != null) {
      setSupportActionBar(toolbar)
    }
    this.appComponent.inject(this)
  }

  protected fun setToolbarTitle(title: CharSequence) {
    toolbar?.title = title
  }

  protected fun setToolbarTitle(@StringRes titleId: Int) {
    toolbar?.setTitle(titleId)
  }

  override fun onDestroy() {
    super.onDestroy()
    BusProvider.get().unregister(this);
  }

  @get:LayoutRes abstract val layoutResId: Int

  /**
   * Get the Main Application component for dependency injection.

   * @return [AppComponent]
   */
  protected val appComponent: AppComponent
    get() = (application as EveryDayHeroApplication).appComponent

  /**
   * Get an Activity module for dependency injection.

   * @return [ActivityModule]
   */
  //  protected val activityModule: ActivityModule
//    get() = ActivityModule(this)

  /**
   * Replace a [Fragment] to this activity's layout.

   * @param containerViewId The container view to where add the fragment.
   * *
   * @param fragment The fragment to be added.
   */
  protected fun replaceFragment(containerViewId: Int, fragment: Fragment) {
    val fragmentTransaction = this.supportFragmentManager.beginTransaction()
    fragmentTransaction.replace(containerViewId, fragment)
    fragmentTransaction.commit()
  }

  override fun onOptionsItemSelected(item: MenuItem): Boolean {
    when (item.itemId) {
      android.R.id.home -> onBackPressed()
    }
    return super.onOptionsItemSelected(item)
  }
}