package me.aungkyawpaing.data.repository

import com.aungkyawpaing.domain.model.AvatarModel
import com.aungkyawpaing.domain.model.AvatarPackModel
import com.aungkyawpaing.domain.model.BuyAvatarPackModel
import com.aungkyawpaing.domain.repository.AvatarPackRepository
import io.reactivex.Observable
import me.aungkyawpaing.data.entity.mapper.AvatarEntitiyMapper
import me.aungkyawpaing.data.entity.mapper.AvatarPackEntityMapper
import me.aungkyawpaing.data.entity.mapper.BuyAvatarPackEntityMapper
import me.aungkyawpaing.data.repository.datasource.avatarpack.AvatarPackDataStoreFactory
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by vincentpaing on 8/24/17.
 */
@Singleton
class AvatarPackDataRepository @Inject constructor(
    private val avatarPackDataStoreFactory: AvatarPackDataStoreFactory) : AvatarPackRepository {

  override fun getShopAvatarPacks(): Observable<List<AvatarPackModel>> {
    return avatarPackDataStoreFactory.createCloudDataStore().getAvatarPacks().map {
      AvatarPackEntityMapper.transform(it)
    }
  }

  override fun buyAvatarPack(packId: Int): Observable<BuyAvatarPackModel> {
    return avatarPackDataStoreFactory.createCloudDataStore().buyAvatarPack(packId).map {
      BuyAvatarPackEntityMapper.transform(it)
    }
  }

  override fun getHeroAvatars(): Observable<List<AvatarModel>> {
    return avatarPackDataStoreFactory.createCloudDataStore().getAvatars().map {
      AvatarEntitiyMapper.transform(it)
    }
  }
}
