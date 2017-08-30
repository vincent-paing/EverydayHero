package me.aungkyawpaing.data.entity.mapper

import com.aungkyawpaing.domain.model.HeroModel
import me.aungkyawpaing.data.entity.HeroEntity

/**
 * Created by vincentpaing on 8/1/17.
 */
object HeroEntityMapper : BaseMapper<HeroEntity, HeroModel>() {

  override fun transform(heroEntity: HeroEntity): HeroModel {
    return HeroModel(heroEntity.heroId, heroEntity.name, heroEntity.level,
        heroEntity.experiencePoint, heroEntity.nextExperiencePoint, heroEntity.avatarUrl,
        heroEntity.point, heroEntity.rank)
  }

}