package me.aungkyawpaing.data.repository.datasource.hero

import android.util.Log
import io.reactivex.Observable
import me.aungkyawpaing.data.cache.HeroCache
import me.aungkyawpaing.data.entity.HeroEntity
import javax.inject.Inject

/**
 * Created by vincentpaing on 7/31/17.
 */
class HeroCacheDataStore
@Inject constructor(
    val heroCache: HeroCache
) : HeroDataStore {

  override fun getHero(): Observable<HeroEntity> {
    return Observable.just(heroCache.get())
  }

  override fun setName(name: String): Observable<HeroEntity> {
    throw Exception()
  }

  override fun setAvatar(avatarId: Int): Observable<HeroEntity> {
    throw Exception()
  }

}