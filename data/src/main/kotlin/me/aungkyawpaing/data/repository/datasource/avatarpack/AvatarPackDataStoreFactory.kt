package me.aungkyawpaing.data.repository.datasource.avatarpack

import me.aungkyawpaing.data.cache.HeroCache
import me.aungkyawpaing.data.network.AvatarPackNetwork
import me.aungkyawpaing.data.repository.datasource.hero.HeroDataStoreFactory
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by vincentpaing on 8/24/17.
 */
@Singleton
class AvatarPackDataStoreFactory @Inject
constructor(val avatarPackNetwork: AvatarPackNetwork,
    val heroCache: HeroCache) {

  fun createCloudDataStore(): AvatarPackDataStore {
    return AvatarPackNetworkDataStore(avatarPackNetwork, heroCache)
  }
}