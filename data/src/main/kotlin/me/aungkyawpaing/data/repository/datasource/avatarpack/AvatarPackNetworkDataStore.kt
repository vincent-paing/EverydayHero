package me.aungkyawpaing.data.repository.datasource.avatarpack

import io.reactivex.Observable
import me.aungkyawpaing.data.cache.HeroCache
import me.aungkyawpaing.data.entity.AvatarEntity
import me.aungkyawpaing.data.entity.AvatarPackEntity
import me.aungkyawpaing.data.entity.BoughtAvatarPackEntity
import me.aungkyawpaing.data.network.AvatarPackNetwork
import javax.inject.Inject

/**
 * Created by vincentpaing on 8/24/17.
 */
class AvatarPackNetworkDataStore @Inject constructor(
    val avatarPackNetwork: AvatarPackNetwork,
    val heroCache: HeroCache
) : AvatarPackDataStore {

  override fun getAvatarPacks(): Observable<List<AvatarPackEntity>> {
    return avatarPackNetwork.getAvatarPacks()
  }

  override fun buyAvatarPack(packId: Int): Observable<BoughtAvatarPackEntity> {
    return avatarPackNetwork.buyAvatarPack(heroCache.get()!!.heroId, packId).doOnNext {
      heroCache.put(it.heroEntity)
    }
  }

  override fun getAvatars(): Observable<List<AvatarEntity>> {
    return avatarPackNetwork.getAvatars()
  }

}