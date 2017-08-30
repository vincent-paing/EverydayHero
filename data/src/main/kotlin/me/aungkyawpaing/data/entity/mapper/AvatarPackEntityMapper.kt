package me.aungkyawpaing.data.entity.mapper

import com.aungkyawpaing.domain.model.AvatarPackModel
import me.aungkyawpaing.data.entity.AvatarPackEntity

/**
 * Created by vincentpaing on 8/24/17.
 */
object AvatarPackEntityMapper : BaseMapper<AvatarPackEntity, AvatarPackModel>() {

  override fun transform(obj: AvatarPackEntity): AvatarPackModel {
    return AvatarPackModel(obj.packId, obj.packName, obj.price, obj.hasAlreadyBought, obj.imgUrl)
  }
}
