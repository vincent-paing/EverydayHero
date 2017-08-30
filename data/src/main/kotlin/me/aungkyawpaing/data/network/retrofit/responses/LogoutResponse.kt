package me.aungkyawpaing.data.network.retrofit.responses

import com.google.gson.annotations.SerializedName

/**
 * Created by vincentpaing on 8/28/17.
 */
data class LogoutResponse(
    @SerializedName("message") val message: String
)