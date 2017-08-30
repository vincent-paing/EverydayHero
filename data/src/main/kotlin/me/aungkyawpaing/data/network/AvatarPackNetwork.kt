package me.aungkyawpaing.data.network

import io.reactivex.Observable
import me.aungkyawpaing.data.entity.AvatarEntity
import me.aungkyawpaing.data.entity.AvatarPackEntity
import me.aungkyawpaing.data.entity.BoughtAvatarPackEntity

/**
 * Created by vincentpaing on 8/24/17.
 */
interface AvatarPackNetwork {
  fun getAvatarPacks(): Observable<List<AvatarPackEntity>>

  fun buyAvatarPack(heroId: String, packId: Int): Observable<BoughtAvatarPackEntity>

  fun getAvatars(): Observable<List<AvatarEntity>>
}