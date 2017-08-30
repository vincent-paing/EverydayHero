package me.aungkyawpaing.data.repository.datasource.hero

import me.aungkyawpaing.data.cache.AuthCache
import me.aungkyawpaing.data.cache.HeroCache
import me.aungkyawpaing.data.network.HeroNetwork
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by vincentpaing on 8/20/17.
 */
@Singleton
class HeroDataStoreFactory @Inject constructor(private val heroCache: HeroCache,
    private val heroNetwork: HeroNetwork,
    private val authCache: AuthCache) {

  fun createCloudDataStore(): HeroDataStore {
    return HeroNetworkDataStore(heroCache, heroNetwork, authCache)
  }

  fun createLocalDataStore(): HeroDataStore {
    return HeroCacheDataStore(heroCache)
  }
}