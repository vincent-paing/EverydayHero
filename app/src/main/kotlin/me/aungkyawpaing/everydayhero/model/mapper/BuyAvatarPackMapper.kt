package me.aungkyawpaing.everydayhero.model.mapper

import com.aungkyawpaing.domain.model.BuyAvatarPackModel
import me.aungkyawpaing.data.entity.mapper.BaseMapper
import me.aungkyawpaing.everydayhero.model.BuyAvatarPack

/**
 * Created by vincentpaing on 8/26/17.
 */
object BuyAvatarPackMapper : BaseMapper<BuyAvatarPackModel, BuyAvatarPack>() {

  override fun transform(obj: BuyAvatarPackModel): BuyAvatarPack {
    return BuyAvatarPack(obj.packId)
  }

}