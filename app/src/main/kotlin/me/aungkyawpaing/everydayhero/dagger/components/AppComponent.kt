package me.aungkyawpaing.everydayhero.dagger.components

import android.content.Context
import com.aungkyawpaing.domain.executor.PostExecutionThread
import com.aungkyawpaing.domain.executor.ThreadExecutor
import com.aungkyawpaing.domain.repository.AuthRepository
import com.aungkyawpaing.domain.repository.AvatarPackRepository
import com.aungkyawpaing.domain.repository.HeroRepository
import com.aungkyawpaing.domain.repository.QuestRepository
import dagger.Component
import dagger.Provides
import me.aungkyawpaing.data.cache.AuthCache
import me.aungkyawpaing.data.cache.HeroCache
import me.aungkyawpaing.data.cache.pref.AuthCachePrefImpl
import me.aungkyawpaing.data.network.AuthNetwork
import me.aungkyawpaing.data.network.AvatarPackNetwork
import me.aungkyawpaing.data.network.HeroNetwork
import me.aungkyawpaing.data.network.QuestNetwork
import me.aungkyawpaing.data.network.retrofit.impl.AuthNetworkRetrofitImpl
import me.aungkyawpaing.data.repository.AuthDataRepository
import me.aungkyawpaing.everydayhero.dagger.modules.AppModule
import me.aungkyawpaing.everydayhero.dagger.modules.DataModule
import me.aungkyawpaing.everydayhero.dagger.modules.RetrofitModule
import me.aungkyawpaing.everydayhero.view.core.BaseActivity
import javax.inject.Singleton

/**
 * Created by vincentpaing on 7/30/17.
 */
@Singleton
@Component(modules = arrayOf(AppModule::class, RetrofitModule::class, DataModule::class))
interface AppComponent {

  fun inject(activity: BaseActivity)

  fun context(): Context

  fun threadExecutor(): ThreadExecutor

  fun postExecutionThread(): PostExecutionThread

  fun providesHeroNetwork(): HeroNetwork

  fun providesHeroCache(): HeroCache

  fun providesHeroRepository(): HeroRepository

  fun providesQuestNetwork(): QuestNetwork

  fun providesQuestRepository(): QuestRepository

  fun provideAvatarPackNetwork(): AvatarPackNetwork

  fun provideAvatarPackRepository(): AvatarPackRepository

  fun providesAuthNetwork(): AuthNetwork

  fun providesAuthCache(): AuthCache

  fun providesAuthRepository(): AuthRepository


}
