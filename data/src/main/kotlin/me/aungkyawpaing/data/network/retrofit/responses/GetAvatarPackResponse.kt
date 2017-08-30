package me.aungkyawpaing.data.network.retrofit.responses

import com.google.gson.annotations.SerializedName

/**
 * Created by vincentpaing on 8/24/17.
 */
data class GetAvatarPackResponse(
    @SerializedName("pack_id") val packId: Int,
    @SerializedName("pack_name") val packName: String,
    @SerializedName("price") val price: Int,
    @SerializedName("is_bought") val hasAlreadyBought: Boolean,
    @SerializedName("img_url") val imgUrl: String
)