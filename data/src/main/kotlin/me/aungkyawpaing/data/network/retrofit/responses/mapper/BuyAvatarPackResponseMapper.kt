package me.aungkyawpaing.data.network.retrofit.responses.mapper

import me.aungkyawpaing.data.entity.BoughtAvatarPackEntity
import me.aungkyawpaing.data.entity.HeroEntity
import me.aungkyawpaing.data.entity.mapper.BaseMapper
import me.aungkyawpaing.data.network.retrofit.responses.BuyAvatarPackResponse

/**
 * Created by vincentpaing on 8/25/17.
 */
object BuyAvatarPackResponseMapper : BaseMapper<BuyAvatarPackResponse, BoughtAvatarPackEntity>() {

  override fun transform(obj: BuyAvatarPackResponse): BoughtAvatarPackEntity {
    with(obj) {
      with(obj) {
        val heroEntity = HeroEntity(hero.heroId, hero.name, hero.lvl, hero.experiencePoint,
            hero.nextExperiencePoint, hero.avatar, hero.point, hero.rank)
        return BoughtAvatarPackEntity(heroEntity, packId)
      }

    }

  }
}