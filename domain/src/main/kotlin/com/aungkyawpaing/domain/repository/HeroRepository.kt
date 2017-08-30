package com.aungkyawpaing.domain.repository

import com.aungkyawpaing.domain.model.HeroModel
import io.reactivex.Observable

/**
 * Created by vincentpaing on 7/31/17.
 */
interface HeroRepository {

  fun getHero(): Observable<HeroModel>

  fun setName(name: String): Observable<Unit>

  fun setAvatar(avatarId: Int): Observable<Unit>

}