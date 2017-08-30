package me.aungkyawpaing.data.network.retrofit

/**
 * Created by vincentpaing on 7/31/17.
 */
object URL {

  const val BASE_URL = "https://everydayhero.herokuapp.com/api/"

  /**
   * FIELDS
   */
  const val FIELD_PHONE_NO = "phone_no"
  const val FIELD_PASSWORD = "password"
  const val FIELD_HERO_ID = "hero_id"
  const val FIELD_QUEST_ID = "quest_id"
  const val FIELD_PACK_ID = "pack_id"
  const val FIELD_AUTH_CODE = "auth_code"
  const val FIELD_NAME = "name"
  const val FIELD_AVATAR_ID = "avatar_id"

  /**
   * URL
   */
  const val URL_LOGIN = "hero/login"
  const val URL_LOGOUT = "hero/logout"
  const val URL_GET_BOUGHT_AVATARS = "hero/avatars"
  const val URL_UPDATE_AVATAR = "hero/updateavatar"
  const val URL_UPDATE_NAME = "hero/updatename"
  const val URL_QUEST = "hero/quests"
  const val URL_FINISH_QUEST = "hero/finishquest"
  const val URL_GET_HERO = "hero/exp"
  const val URL_GET_AVATAR_PACKS = "avatar_packs"
  const val URL_BUY_AVATAR_PACKS = "avatar_packs/buy"


  /**
   * COMMON PARAMETERS
   */
  const val PARAM_HERO_ID = "hero_id"
  const val PARAM_QUEST_ID = "quest_id"
}