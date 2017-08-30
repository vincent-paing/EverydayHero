package me.aungkyawpaing.data.network.retrofit.responses

import com.google.gson.annotations.SerializedName

/**
 * Created by vincentpaing on 8/28/17.
 */
data class GetAvatarResponse(
    @SerializedName("avatar_id") val avatarId: Int,
    @SerializedName("pack_id") val packId: Int,
    @SerializedName("url") val url: String,
    @SerializedName("has_unlocked") val isUnlocked: Boolean,
    @SerializedName("require_lvl") val requireLevel: Int,
    @SerializedName("is_current") val isCurrentlyUsed: Boolean
)