package me.aungkyawpaing.data.network.retrofit.responses.mapper

import me.aungkyawpaing.data.entity.HeroEntity
import me.aungkyawpaing.data.entity.LoginEntity
import me.aungkyawpaing.data.entity.mapper.BaseMapper
import me.aungkyawpaing.data.network.retrofit.responses.LoginResponse

/**
 * Created by vincentpaing on 8/5/17.
 */
object LoginResponseMapper : BaseMapper<LoginResponse, LoginEntity>() {

  override fun transform(obj: LoginResponse): LoginEntity {
    with(obj) {
      val heroEntity = HeroEntity(hero.heroId, hero.name ?: "FOOBAR", hero.lvl,
          hero.experiencePoint,
          hero.nextExperiencePoint, hero.avatar, hero.point, hero.rank)
      return LoginEntity(heroEntity, isFirstTime, authToken)
    }
  }

}