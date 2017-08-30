package me.aungkyawpaing.data.cache.pref

import android.content.SharedPreferences
import com.google.gson.Gson
import me.aungkyawpaing.data.entity.HeroEntity
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by vincentpaing on 7/31/17.
 */
@Singleton
class PrefManager @Inject constructor(val preference: SharedPreferences,
    val gson: Gson) {

  val KEY_HERO = "KEY_HERO"
  val KEY_ACCESS_TOKEN = "ACCESS_TOKEN"
  val KEY_HERO_ID = "KEY_HERO_ID"
  val KEY_IS_LOGGED_IN = "KEY_IS_LOGGED_IN"
  val KEY_IS_FIRST_TIME = "KEY_IS_FIRST_TIME"


  fun putHero(heroEntity: HeroEntity) {
    preference.edit().putString(KEY_HERO, gson.toJson(heroEntity)).apply()
  }

  fun getHero(): HeroEntity? {
    return gson.fromJson(preference.getString(KEY_HERO, null), HeroEntity::class.java)
  }

  fun putAccessToken(accessToken: String) {
    preference.edit().putString(KEY_ACCESS_TOKEN, accessToken).apply()
  }

  fun getAcessToken(): String? {
    return preference.getString(KEY_ACCESS_TOKEN, null)
  }

  fun putHeroID(heroID: String) {
    preference.edit().putString(KEY_HERO_ID, heroID).apply()
  }

  fun getHeroID(): String? {
    return preference.getString(KEY_HERO_ID, null)
  }

  fun putIsLoggedIn(isLoggedIn: Boolean) {
    preference.edit().putBoolean(KEY_IS_LOGGED_IN, isLoggedIn).apply()
  }

  fun getIsLoggedIn(): Boolean {
    return preference.getBoolean(KEY_IS_LOGGED_IN, false)
  }

  fun putIsFirstTime(isFirstTime: Boolean) {
    preference.edit().putBoolean(KEY_IS_FIRST_TIME, isFirstTime).apply()
  }

  fun getIsFirstTime(): Boolean {
    return preference.getBoolean(KEY_IS_FIRST_TIME, false)
  }

  fun clear() {
    preference.edit().clear().apply()
  }


}