package me.aungkyawpaing.data.network.retrofit.responses

import com.google.gson.annotations.SerializedName

/**
 * Created by vincentpaing on 8/20/17.
 */
data class GetHeroResponse(
    @SerializedName("exp") val exp: Long,
    @SerializedName("hero_id") val heroId: String,
    @SerializedName("lvl") val lvl: Int,
    @SerializedName("name") val name: String,
    @SerializedName("next_exp") val nextExperiencePoint: Long,
    @SerializedName("avatar") val avatar: String,
    @SerializedName("point") val point: Int,
    @SerializedName("rank") val rank: String
)