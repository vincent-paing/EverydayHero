package me.aungkyawpaing.data.network.retrofit

import io.reactivex.Observable
import me.aungkyawpaing.data.network.retrofit.responses.BuyAvatarPackResponse
import me.aungkyawpaing.data.network.retrofit.responses.CompleteQuestResponse
import me.aungkyawpaing.data.network.retrofit.responses.GetAvatarPackResponse
import me.aungkyawpaing.data.network.retrofit.responses.GetAvatarResponse
import me.aungkyawpaing.data.network.retrofit.responses.GetHeroResponse
import me.aungkyawpaing.data.network.retrofit.responses.GetQuestListResponse
import me.aungkyawpaing.data.network.retrofit.responses.LoginResponse
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

/**
 * Created by vincentpaing on 7/31/17.
 */
interface EverydayHeroApi {

  @FormUrlEncoded
  @POST(URL.URL_LOGIN)
  fun login(
      @Field(URL.FIELD_AUTH_CODE) authCode: String
  ): Observable<LoginResponse>

  @GET(URL.URL_QUEST)
  fun getQuests(
  ): Observable<List<GetQuestListResponse>>

  @FormUrlEncoded
  @POST(URL.URL_FINISH_QUEST)
  fun completeQuest(
      @Field(URL.FIELD_HERO_ID) heroId: String,
      @Field(URL.FIELD_QUEST_ID) questId: Int
  ): Observable<CompleteQuestResponse>

  @GET(URL.URL_GET_HERO)
  fun getHero(): Observable<GetHeroResponse>

  @GET(URL.URL_GET_AVATAR_PACKS)
  fun getAvatarPacks(): Observable<List<GetAvatarPackResponse>>

  @FormUrlEncoded
  @POST(URL.URL_BUY_AVATAR_PACKS)
  fun buyAvatarPack(
      @Field(URL.FIELD_HERO_ID) heroID: String,
      @Field(URL.FIELD_PACK_ID) packID: Int
  ): Observable<BuyAvatarPackResponse>

  @FormUrlEncoded
  @POST(URL.URL_UPDATE_NAME)
  fun setName(
      @Field(URL.FIELD_NAME) name: String
  ): Observable<GetHeroResponse>

  @FormUrlEncoded
  @POST(URL.URL_UPDATE_AVATAR)
  fun setAvatar(
      @Field(URL.FIELD_AVATAR_ID) avatarID: Int
  ): Observable<GetHeroResponse>

  @POST(URL.URL_LOGOUT)
  fun logOut(): Observable<GetHeroResponse>

  @GET(URL.URL_GET_BOUGHT_AVATARS)
  fun getAvatars(): Observable<List<GetAvatarResponse>>


}