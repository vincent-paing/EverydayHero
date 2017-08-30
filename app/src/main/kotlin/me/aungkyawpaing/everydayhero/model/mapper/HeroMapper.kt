package me.aungkyawpaing.everydayhero.model.mapper

import com.aungkyawpaing.domain.model.HeroModel
import me.aungkyawpaing.data.entity.mapper.BaseMapper
import me.aungkyawpaing.everydayhero.model.Hero

/**
 * Created by vincentpaing on 8/1/17.
 */
object HeroMapper : BaseMapper<HeroModel, Hero>() {

  override fun transform(heroModel: HeroModel): Hero {
    return Hero(heroModel.name, heroModel.level, heroModel.experiencePoint,
        heroModel.nextExperiencePoint, heroModel.avatarUrl, heroModel.point, heroModel.rank)
  }

}