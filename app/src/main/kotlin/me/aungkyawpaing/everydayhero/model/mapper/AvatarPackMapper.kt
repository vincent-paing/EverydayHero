package me.aungkyawpaing.everydayhero.model.mapper

import com.aungkyawpaing.domain.model.AvatarPackModel
import me.aungkyawpaing.data.entity.mapper.BaseMapper
import me.aungkyawpaing.everydayhero.model.AvatarPack

/**
 * Created by vincentpaing on 8/24/17.
 */
object AvatarPackMapper : BaseMapper<AvatarPackModel, AvatarPack>() {

  override fun transform(obj: AvatarPackModel): AvatarPack {
    return AvatarPack(obj.packId, obj.packName, obj.price, obj.hasAlreadyBought, obj.imgUrl)
  }


}