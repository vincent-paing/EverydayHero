package me.aungkyawpaing.data.network.retrofit.responses.mapper

import me.aungkyawpaing.data.entity.AvatarEntity
import me.aungkyawpaing.data.entity.mapper.BaseMapper
import me.aungkyawpaing.data.network.retrofit.responses.GetAvatarResponse

/**
 * Created by vincentpaing on 8/28/17.
 */
object GetAvatarResponseMapper : BaseMapper<GetAvatarResponse, AvatarEntity>() {

  override fun transform(obj: GetAvatarResponse): AvatarEntity {
    return AvatarEntity(obj.avatarId, obj.packId, obj.url, obj.isUnlocked, obj.requireLevel,
        obj.isCurrentlyUsed)
  }

}