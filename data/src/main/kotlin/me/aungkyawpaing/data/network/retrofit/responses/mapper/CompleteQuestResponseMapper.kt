package me.aungkyawpaing.data.network.retrofit.responses.mapper

import me.aungkyawpaing.data.entity.CompleteQuestEntity
import me.aungkyawpaing.data.entity.HeroEntity
import me.aungkyawpaing.data.entity.mapper.BaseMapper
import me.aungkyawpaing.data.network.retrofit.responses.CompleteQuestResponse

/**
 * Created by vincentpaing on 8/16/17.
 */
object CompleteQuestResponseMapper : BaseMapper<CompleteQuestResponse, CompleteQuestEntity>() {

  override fun transform(obj: CompleteQuestResponse): CompleteQuestEntity {
    with(obj) {
      val heroEntity = HeroEntity(hero.heroId, hero.name, hero.lvl, hero.experiencePoint,
          hero.nextExperiencePoint, hero.avatar, hero.point, hero.rank)
      return CompleteQuestEntity(heroEntity, didLvlUp)
    }

  }
}