package me.aungkyawpaing.data.cache.pref

import me.aungkyawpaing.data.cache.AuthCache
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by vincentpaing on 8/26/17.
 */
@Singleton
class AuthCachePrefImpl
@Inject constructor(val prefManager: PrefManager) : AuthCache {

  override fun putIsLoggedIn(isLoggedIn: Boolean) {
    prefManager.putIsLoggedIn(isLoggedIn)
  }

  override fun getIsLoggedIn(): Boolean {
    return prefManager.getIsLoggedIn()
  }

  override fun putIsFirstTime(isFirstTime: Boolean) {
    prefManager.putIsFirstTime(isFirstTime)
  }

  override fun getIsFirstTime(): Boolean {
    return prefManager.getIsFirstTime()
  }

  override fun putAccessToken(accessToken: String) {
    prefManager.putAccessToken(accessToken)
  }

  override fun getAccessToken(): String? {
    return prefManager.getAcessToken()
  }

  override fun clear() {
    prefManager.clear()
  }

}