package me.aungkyawpaing.data.repository.datasource.auth

import io.reactivex.Observable
import me.aungkyawpaing.data.cache.AuthCache
import me.aungkyawpaing.data.entity.LoginEntity
import me.aungkyawpaing.data.entity.LoginStatusEntity
import javax.inject.Inject

/**
 * Created by vincentpaing on 8/26/17.
 */
class AuthCacheDataStore @Inject constructor(val authCache: AuthCache) : AuthDataStore {

  override fun logout(): Observable<Unit> {
    throw Exception()
  }

  override fun login(authCode: String): Observable<LoginEntity> {
    throw Exception()
  }

  override fun getLoginStatus(): Observable<LoginStatusEntity> {
    return Observable.just(LoginStatusEntity(authCache.getIsFirstTime(), authCache.getIsLoggedIn()))
  }
}
