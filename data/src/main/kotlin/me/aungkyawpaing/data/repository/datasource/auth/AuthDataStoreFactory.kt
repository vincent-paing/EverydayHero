package me.aungkyawpaing.data.repository.datasource.auth

import me.aungkyawpaing.data.cache.AuthCache
import me.aungkyawpaing.data.cache.HeroCache
import me.aungkyawpaing.data.network.AuthNetwork
import me.aungkyawpaing.data.repository.datasource.hero.HeroDataStoreFactory
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by vincentpaing on 8/26/17.
 */
@Singleton
class AuthDataStoreFactory @Inject constructor(private val authNetwork: AuthNetwork,
    private val authCache: AuthCache,
    private val heroCache: HeroCache) {

  fun createCloudDataStore(): AuthDataStore {
    return AuthNetworkDataStore(authNetwork, authCache, heroCache)
  }

  fun createLocalDataStore(): AuthDataStore {
    return AuthCacheDataStore(authCache)
  }


}
