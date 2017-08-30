package me.aungkyawpaing.data.cache.pref

import me.aungkyawpaing.data.cache.HeroCache
import me.aungkyawpaing.data.entity.HeroEntity
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by vincentpaing on 7/31/17.
 */
@Singleton
class HeroCachePrefImpl
@Inject constructor(val prefManager: PrefManager)
  : HeroCache {

  override fun get(): HeroEntity? {
    return prefManager.getHero()
  }

  override fun put(heroEntity: HeroEntity) {
    prefManager.putHero(heroEntity)
  }

  override fun getHeroID(): String? {
    return get()?.heroId
  }
}