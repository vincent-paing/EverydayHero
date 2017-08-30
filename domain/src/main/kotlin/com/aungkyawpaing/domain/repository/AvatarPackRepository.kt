package com.aungkyawpaing.domain.repository

import com.aungkyawpaing.domain.model.AvatarModel
import com.aungkyawpaing.domain.model.AvatarPackModel
import com.aungkyawpaing.domain.model.BuyAvatarPackModel
import io.reactivex.Observable

/**
 * Created by vincentpaing on 8/24/17.
 */
interface AvatarPackRepository {

  fun getShopAvatarPacks(): Observable<List<AvatarPackModel>>

  fun getHeroAvatars(): Observable<List<AvatarModel>>

  fun buyAvatarPack(packId: Int): Observable<BuyAvatarPackModel>
}