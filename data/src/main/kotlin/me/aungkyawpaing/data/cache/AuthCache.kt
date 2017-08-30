package me.aungkyawpaing.data.cache

/**
 * Created by vincentpaing on 8/26/17.
 */
interface AuthCache {

  fun putIsLoggedIn(isLoggedIn: Boolean)

  fun getIsLoggedIn(): Boolean

  fun putIsFirstTime(isFirstTime: Boolean)

  fun getIsFirstTime(): Boolean

  fun putAccessToken(accessToken: String)

  fun getAccessToken(): String?

  fun clear()

}
