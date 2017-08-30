package me.aungkyawpaing.everydayhero.dagger.modules

import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager
import com.aungkyawpaing.domain.executor.PostExecutionThread
import com.aungkyawpaing.domain.executor.ThreadExecutor
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import me.aungkyawpaing.data.executor.JobExecutor
import me.aungkyawpaing.everydayhero.EveryDayHeroApplication
import me.aungkyawpaing.everydayhero.UIThread
import javax.inject.Singleton

/**
 * Created by vincentpaing on 7/30/17.
 */
@Module class AppModule(private var application: EveryDayHeroApplication) {

  @Provides @Singleton fun provideContext(): Context {
    return this.application
  }

  @Provides @Singleton fun provideThreadExecutor(
      jobExecutor: JobExecutor): ThreadExecutor {
    return jobExecutor
  }

  @Provides @Singleton fun providePostExecutionThread(
      uiThread: UIThread): PostExecutionThread {
    return uiThread
  }

  @Provides @Singleton fun providesGson(): Gson {
    return GsonBuilder().create()
  }


  @Provides @Singleton fun providesSharedPreferences(context: Context): SharedPreferences {
    return PreferenceManager.getDefaultSharedPreferences(context)
  }
}