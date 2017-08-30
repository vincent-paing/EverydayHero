package me.aungkyawpaing.data.network.retrofit.responses.mapper

import me.aungkyawpaing.data.entity.HeroEntity
import me.aungkyawpaing.data.entity.mapper.BaseMapper
import me.aungkyawpaing.data.network.retrofit.responses.GetHeroResponse

/**
 * Created by vincentpaing on 8/20/17.
 */
object GetHeroResponseMapper : BaseMapper<GetHeroResponse, HeroEntity>() {

  override fun transform(obj: GetHeroResponse): HeroEntity {
    return HeroEntity(obj.heroId, obj.name, obj.lvl, obj.exp, obj.nextExperiencePoint, obj.avatar, obj.point, obj.rank)
  }

}