package me.aungkyawpaing.data.repository.datasource.auth

import android.util.Log
import io.reactivex.Observable
import me.aungkyawpaing.data.cache.AuthCache
import me.aungkyawpaing.data.cache.HeroCache
import me.aungkyawpaing.data.entity.HeroEntity
import me.aungkyawpaing.data.entity.LoginEntity
import me.aungkyawpaing.data.entity.LoginStatusEntity
import me.aungkyawpaing.data.network.AuthNetwork
import me.aungkyawpaing.data.network.HeroNetwork
import javax.inject.Inject

/**
 * Created by vincentpaing on 8/1/17.
 */
class AuthNetworkDataStore @Inject constructor(
    var authNetwork: AuthNetwork,
    var authCache: AuthCache,
    var heroCache: HeroCache
) : AuthDataStore {

  override fun login(authCode: String): Observable<LoginEntity> {
    return authNetwork.login(authCode).doOnNext {
      heroCache.put(it.heroEntity)
      authCache.putIsFirstTime(it.isFirstTime)
      authCache.putIsLoggedIn(true)
      authCache.putAccessToken(it.authToken)
    }
  }

  override fun logout(): Observable<Unit> {
    return authNetwork.logout().doOnNext {
      authCache.clear()
    }
  }

  override fun getLoginStatus(): Observable<LoginStatusEntity> {
    throw Exception()
  }

}
