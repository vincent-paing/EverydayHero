package me.aungkyawpaing.data.repository.datasource.hero

import io.reactivex.Observable
import me.aungkyawpaing.data.entity.HeroEntity

/**
 * Created by vincentpaing on 7/31/17.
 */
interface HeroDataStore {

  fun getHero(): Observable<HeroEntity>

  fun setName(name: String): Observable<HeroEntity>

  fun setAvatar(avatarId: Int): Observable<HeroEntity>
}