package me.aungkyawpaing.data.network.retrofit

import io.reactivex.Observable
import me.aungkyawpaing.data.entity.AvatarEntity
import me.aungkyawpaing.data.entity.AvatarPackEntity
import me.aungkyawpaing.data.entity.BoughtAvatarPackEntity
import me.aungkyawpaing.data.entity.CompleteQuestEntity
import me.aungkyawpaing.data.entity.HeroEntity
import me.aungkyawpaing.data.entity.LoginEntity
import me.aungkyawpaing.data.entity.QuestEntitiy
import me.aungkyawpaing.data.network.retrofit.responses.mapper.BuyAvatarPackResponseMapper
import me.aungkyawpaing.data.network.retrofit.responses.mapper.CompleteQuestResponseMapper
import me.aungkyawpaing.data.network.retrofit.responses.mapper.GetAvatarPackResponseMapper
import me.aungkyawpaing.data.network.retrofit.responses.mapper.GetAvatarResponseMapper
import me.aungkyawpaing.data.network.retrofit.responses.mapper.GetHeroResponseMapper
import me.aungkyawpaing.data.network.retrofit.responses.mapper.GetQuestListResponseMapper
import me.aungkyawpaing.data.network.retrofit.responses.mapper.LoginResponseMapper
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by vincentpaing on 7/31/17.
 */
@Singleton
class NetworkRequestManager
@Inject constructor(
    private val everydayHeroApi: EverydayHeroApi
) {

  fun login(authCode: String): Observable<LoginEntity> {
    return everydayHeroApi.login(authCode).map {
      LoginResponseMapper.transform(it)
    }
  }

  fun logout(): Observable<Unit> {
    return everydayHeroApi.logOut().map { Unit }
  }

  fun setName(name: String): Observable<HeroEntity> {
    return everydayHeroApi.setName(name).map {
      GetHeroResponseMapper.transform(it)
    }
  }

  fun setAvatar(avatarId: Int): Observable<HeroEntity> {
    return everydayHeroApi.setAvatar(avatarId).map {
      GetHeroResponseMapper.transform(it)
    }
  }

  fun getQuestList(): Observable<List<QuestEntitiy>> {
    return everydayHeroApi.getQuests().map { GetQuestListResponseMapper.transform(it) }
  }

  fun completeQuest(heroId: String, questId: Int): Observable<CompleteQuestEntity> {
    return everydayHeroApi.completeQuest(heroId,
        questId).map { CompleteQuestResponseMapper.transform(it) }
  }

  fun getHero(): Observable<HeroEntity> {
    return everydayHeroApi.getHero().map { GetHeroResponseMapper.transform(it) }
  }

  fun getAvatarPacks(): Observable<List<AvatarPackEntity>> {
    return everydayHeroApi.getAvatarPacks().map {
      GetAvatarPackResponseMapper.transform(it)
    }
  }

  fun buyAvatarPack(heroId: String, packId: Int): Observable<BoughtAvatarPackEntity> {
    return everydayHeroApi.buyAvatarPack(heroId, packId).map {
      BuyAvatarPackResponseMapper.transform(it)
    }
  }

  fun getAvatars(): Observable<List<AvatarEntity>> {
    return everydayHeroApi.getAvatars().map {
      GetAvatarResponseMapper.transform(it)
    }
  }

}
