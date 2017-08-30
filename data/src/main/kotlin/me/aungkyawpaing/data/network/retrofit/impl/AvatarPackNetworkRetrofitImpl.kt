package me.aungkyawpaing.data.network.retrofit.impl

import io.reactivex.Observable
import me.aungkyawpaing.data.entity.AvatarEntity
import me.aungkyawpaing.data.entity.AvatarPackEntity
import me.aungkyawpaing.data.entity.BoughtAvatarPackEntity
import me.aungkyawpaing.data.network.AvatarPackNetwork
import me.aungkyawpaing.data.network.retrofit.NetworkRequestManager
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by vincentpaing on 8/24/17.
 */
@Singleton
class AvatarPackNetworkRetrofitImpl @Inject constructor(
    val networkRequestManager: NetworkRequestManager) : AvatarPackNetwork {

  override fun getAvatarPacks(): Observable<List<AvatarPackEntity>> {
    return networkRequestManager.getAvatarPacks()
  }

  override fun buyAvatarPack(heroId: String, packId: Int): Observable<BoughtAvatarPackEntity> {
    return networkRequestManager.buyAvatarPack(heroId, packId)
  }

  override fun getAvatars(): Observable<List<AvatarEntity>> {
    return networkRequestManager.getAvatars()
  }

}