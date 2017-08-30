package me.aungkyawpaing.everydayhero.dagger.modules

import com.aungkyawpaing.domain.repository.AuthRepository
import com.aungkyawpaing.domain.repository.AvatarPackRepository
import com.aungkyawpaing.domain.repository.HeroRepository
import com.aungkyawpaing.domain.repository.QuestRepository
import dagger.Module
import dagger.Provides
import me.aungkyawpaing.data.cache.AuthCache
import me.aungkyawpaing.data.cache.HeroCache
import me.aungkyawpaing.data.cache.pref.AuthCachePrefImpl
import me.aungkyawpaing.data.cache.pref.HeroCachePrefImpl
import me.aungkyawpaing.data.network.AuthNetwork
import me.aungkyawpaing.data.network.AvatarPackNetwork
import me.aungkyawpaing.data.network.HeroNetwork
import me.aungkyawpaing.data.network.QuestNetwork
import me.aungkyawpaing.data.network.retrofit.impl.AuthNetworkRetrofitImpl
import me.aungkyawpaing.data.network.retrofit.impl.AvatarPackNetworkRetrofitImpl
import me.aungkyawpaing.data.network.retrofit.impl.HeroNetworkRetrofitImpl
import me.aungkyawpaing.data.network.retrofit.impl.QuestNetworkRetrofitImpl
import me.aungkyawpaing.data.repository.AuthDataRepository
import me.aungkyawpaing.data.repository.AvatarPackDataRepository
import me.aungkyawpaing.data.repository.HeroDataRepository
import me.aungkyawpaing.data.repository.QuestDataRepository
import javax.inject.Singleton

/**
 * Created by vincentpaing on 8/5/17.
 */
@Module
class DataModule {

  //Auth
  @Provides
  @Singleton
  fun providesAuthNetwork(
      authNetwork: AuthNetworkRetrofitImpl): AuthNetwork {
    return authNetwork
  }

  @Provides
  @Singleton
  fun providesAuthCache(
      authCache: AuthCachePrefImpl): AuthCache {
    return authCache
  }

  @Provides
  @Singleton
  fun providesAuthRepository(
      authRepository: AuthDataRepository): AuthRepository {
    return authRepository
  }

  //Hero
  @Provides
  @Singleton
  fun providesHeroNetwork(
      heroNetwork: HeroNetworkRetrofitImpl): HeroNetwork {
    return heroNetwork
  }

  @Provides
  @Singleton
  fun providesHeroCache(
      heroCache: HeroCachePrefImpl): HeroCache {
    return heroCache
  }

  @Provides
  @Singleton
  fun providesHeroRepository(
      heroDataRepository: HeroDataRepository): HeroRepository {
    return heroDataRepository
  }

  //Quest
  @Provides
  @Singleton
  fun providesQuestNetwork(
      questNetwork: QuestNetworkRetrofitImpl): QuestNetwork {
    return questNetwork
  }

  @Provides
  @Singleton
  fun providesQuestRepository(
      questRepository: QuestDataRepository): QuestRepository {
    return questRepository
  }

  //Avatar Packs
  @Provides
  @Singleton
  fun provideAvatarPackNetwork(
      avatarNetwork: AvatarPackNetworkRetrofitImpl): AvatarPackNetwork {
    return avatarNetwork
  }

  @Provides
  @Singleton
  fun provideAvatarPackRepository(
      avatarPackRepository: AvatarPackDataRepository): AvatarPackRepository {
    return avatarPackRepository
  }
}