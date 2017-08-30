package me.aungkyawpaing.data.network.retrofit.responses.mapper

import me.aungkyawpaing.data.entity.AvatarPackEntity
import me.aungkyawpaing.data.entity.mapper.BaseMapper
import me.aungkyawpaing.data.network.retrofit.responses.GetAvatarPackResponse

/**
 * Created by vincentpaing on 8/24/17.
 */
object GetAvatarPackResponseMapper : BaseMapper<GetAvatarPackResponse, AvatarPackEntity>() {

  override fun transform(obj: GetAvatarPackResponse): AvatarPackEntity {
    return AvatarPackEntity(obj.packId, obj.packName, obj.price, obj.hasAlreadyBought, obj.imgUrl)
  }


}