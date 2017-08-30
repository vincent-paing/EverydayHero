package me.aungkyawpaing.data.cache

import me.aungkyawpaing.data.entity.HeroEntity

/**
 * Created by vincentpaing on 7/31/17.
 */
interface HeroCache {

  fun put(heroEntity: HeroEntity)

  fun get(): HeroEntity?

  fun getHeroID(): String?
}