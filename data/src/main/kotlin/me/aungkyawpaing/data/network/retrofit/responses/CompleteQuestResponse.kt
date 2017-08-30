package me.aungkyawpaing.data.network.retrofit.responses

import com.google.gson.annotations.SerializedName

/**
 * Created by vincentpaing on 8/16/17.
 */
data class CompleteQuestResponse(
    @SerializedName("hero") val hero: HeroJSONObject,
    @SerializedName("is_lvl_up") val didLvlUp: Boolean
) {
  data class HeroJSONObject(
      @SerializedName("exp") val experiencePoint: Long,
      @SerializedName("hero_id") val heroId: String,
      @SerializedName("lvl") val lvl: Int,
      @SerializedName("name") val name: String,
      @SerializedName("next_exp") val nextExperiencePoint: Long,
      @SerializedName("avatar") val avatar: String,
      @SerializedName("point") val point: Int,
      @SerializedName("rank") val rank: String
  )
}

