package me.aungkyawpaing.data.network.retrofit.impl

import io.reactivex.Observable
import me.aungkyawpaing.data.entity.HeroEntity
import me.aungkyawpaing.data.network.HeroNetwork
import me.aungkyawpaing.data.network.retrofit.NetworkRequestManager
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by vincentpaing on 7/31/17.
 */
@Singleton
class HeroNetworkRetrofitImpl
@Inject constructor(val networkRequestManager: NetworkRequestManager)
  : HeroNetwork {

  override fun getHero(): Observable<HeroEntity> {
    return networkRequestManager.getHero()
  }

  override fun setName(name: String): Observable<HeroEntity> {
    return networkRequestManager.setName(name)
  }

  override fun setAvatar(avatarId: Int): Observable<HeroEntity> {
    return networkRequestManager.setAvatar(avatarId)
  }
}