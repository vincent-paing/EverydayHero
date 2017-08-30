package me.aungkyawpaing.data.network

import io.reactivex.Observable
import me.aungkyawpaing.data.entity.HeroEntity

/**
 * Created by vincentpaing on 7/31/17.
 */
public interface HeroNetwork {

  fun getHero(): Observable<HeroEntity>

  fun setName(name: String): Observable<HeroEntity>

  fun setAvatar(avatarId: Int): Observable<HeroEntity>
}