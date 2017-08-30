package me.aungkyawpaing.data.repository

import com.aungkyawpaing.domain.model.HeroModel
import com.aungkyawpaing.domain.repository.HeroRepository
import io.reactivex.Observable
import me.aungkyawpaing.data.entity.mapper.HeroEntityMapper
import me.aungkyawpaing.data.repository.datasource.auth.AuthNetworkDataStore
import me.aungkyawpaing.data.repository.datasource.hero.HeroDataStoreFactory
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by vincentpaing on 7/31/17.
 */
@Singleton
class HeroDataRepository
@Inject constructor(private val authDataStore: AuthNetworkDataStore,
    private val heroDataStoreFactory: HeroDataStoreFactory)
  : HeroRepository {

  override fun getHero(): Observable<HeroModel> {
    return heroDataStoreFactory.createCloudDataStore().getHero()
        .publish {
          Observable.merge(it.onErrorResumeNext { _: Throwable ->
            heroDataStoreFactory.createLocalDataStore().getHero()
          }, heroDataStoreFactory.createLocalDataStore().getHero().takeUntil(it))
        }.onErrorResumeNext { _: Throwable ->
      heroDataStoreFactory.createLocalDataStore().getHero()
    }.map { HeroEntityMapper.transform(it) }
  }

  override fun setName(name: String): Observable<Unit> {
    return heroDataStoreFactory.createCloudDataStore().setName(name).map { Unit }
  }

  override fun setAvatar(avatarId: Int): Observable<Unit> {
    return heroDataStoreFactory.createCloudDataStore().setAvatar(avatarId).map { Unit}

  }

}