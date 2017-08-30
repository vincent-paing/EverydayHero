package me.aungkyawpaing.data.repository.datasource.hero

import io.reactivex.Observable
import me.aungkyawpaing.data.cache.AuthCache
import me.aungkyawpaing.data.cache.HeroCache
import me.aungkyawpaing.data.entity.HeroEntity
import me.aungkyawpaing.data.network.HeroNetwork
import javax.inject.Inject

/**
 * Created by vincentpaing on 8/20/17.
 */
class HeroNetworkDataStore @Inject constructor(val heroCache: HeroCache,
    val heroNetwork: HeroNetwork,
    val authCache: AuthCache) : HeroDataStore {


  override fun getHero(): Observable<HeroEntity> {
    return heroNetwork.getHero().doOnNext {
      heroCache.put(it)
    }
  }

  override fun setName(name: String): Observable<HeroEntity> {
    return heroNetwork.setName(name).doOnNext {
      heroCache.put(it)
      authCache.putIsFirstTime(false)
    }
  }

  override fun setAvatar(avatarId: Int): Observable<HeroEntity> {
    return heroNetwork.setAvatar(avatarId).doOnNext {
      heroCache.put(it)
    }
  }

}