package me.aungkyawpaing.data.network.retrofit.impl

import io.reactivex.Observable
import me.aungkyawpaing.data.entity.LoginEntity
import me.aungkyawpaing.data.network.AuthNetwork
import me.aungkyawpaing.data.network.retrofit.NetworkRequestManager
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by vincentpaing on 8/26/17.
 */
@Singleton
class AuthNetworkRetrofitImpl
@Inject constructor(val networkRequestManager: NetworkRequestManager) : AuthNetwork {

  override fun login(authCode: String): Observable<LoginEntity> {
    return networkRequestManager.login(authCode)
  }

  override fun logout(): Observable<Unit> {
    return networkRequestManager.logout()
  }

}