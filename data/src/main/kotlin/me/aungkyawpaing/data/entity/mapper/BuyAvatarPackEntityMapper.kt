package me.aungkyawpaing.data.entity.mapper

import com.aungkyawpaing.domain.model.BuyAvatarPackModel
import me.aungkyawpaing.data.entity.BoughtAvatarPackEntity

/**
 * Created by vincentpaing on 8/26/17.
 */
object BuyAvatarPackEntityMapper : BaseMapper<BoughtAvatarPackEntity, BuyAvatarPackModel>() {

  override fun transform(obj: BoughtAvatarPackEntity): BuyAvatarPackModel {
    return BuyAvatarPackModel(obj.packId)
  }

}