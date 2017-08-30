package me.aungkyawpaing.data.entity.mapper

import com.aungkyawpaing.domain.model.AvatarModel
import me.aungkyawpaing.data.entity.AvatarEntity

/**
 * Created by vincentpaing on 8/28/17.
 */
object AvatarEntitiyMapper : BaseMapper<AvatarEntity, AvatarModel>() {

  override fun transform(obj: AvatarEntity): AvatarModel {
    return AvatarModel(obj.avatarId, obj.packId, obj.url, obj.isUnlocked, obj.requireLevel,
        obj.isCurrentlyUsed)
  }

}