package me.aungkyawpaing.data.repository.datasource.avatarpack

import io.reactivex.Observable
import me.aungkyawpaing.data.entity.AvatarEntity
import me.aungkyawpaing.data.entity.AvatarPackEntity
import me.aungkyawpaing.data.entity.BoughtAvatarPackEntity

/**
 * Created by vincentpaing on 8/24/17.
 */
interface AvatarPackDataStore {

  fun getAvatarPacks(): Observable<List<AvatarPackEntity>>

  fun buyAvatarPack(packId: Int): Observable<BoughtAvatarPackEntity>

  fun getAvatars(): Observable<List<AvatarEntity>>
}