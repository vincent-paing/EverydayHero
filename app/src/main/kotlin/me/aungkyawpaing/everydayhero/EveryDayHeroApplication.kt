package me.aungkyawpaing.everydayhero

import android.app.Application
import me.aungkyawpaing.everydayhero.dagger.components.AppComponent
import me.aungkyawpaing.everydayhero.dagger.modules.AppModule
import me.aungkyawpaing.everydayhero.dagger.components.DaggerAppComponent
import me.aungkyawpaing.everydayhero.dagger.modules.RetrofitModule
import timber.log.Timber.DebugTree
import timber.log.Timber


/**
 * Created by vincentpaing on 7/30/17.
 */
class EveryDayHeroApplication : Application() {

  lateinit var appComponent: AppComponent

  override fun onCreate() {
    super.onCreate()
    this.initDagger()

    if (BuildConfig.DEBUG) {
      Timber.plant(DebugTree())
    }
  }

  private fun initDagger() {
    appComponent = DaggerAppComponent.builder().appModule(AppModule(this)).retrofitModule(
        RetrofitModule(applicationContext)).build()
  }

}