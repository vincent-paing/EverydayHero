package me.aungkyawpaing.everydayhero.model.mapper

import com.aungkyawpaing.domain.model.AvatarModel
import me.aungkyawpaing.data.entity.AvatarEntity
import me.aungkyawpaing.data.entity.mapper.BaseMapper
import me.aungkyawpaing.everydayhero.model.Avatar

/**
 * Created by vincentpaing on 8/28/17.
 */
object AvatarMapper : BaseMapper<AvatarModel, Avatar>() {

  override fun transform(obj: AvatarModel): Avatar {
    return Avatar(obj.avatarId, obj.packId, obj.url, obj.isUnlocked, obj.requireLevel,
        obj.isCurrentlyUsed)
  }

}