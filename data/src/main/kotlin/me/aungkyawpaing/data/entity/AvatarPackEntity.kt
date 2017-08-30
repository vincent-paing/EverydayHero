package me.aungkyawpaing.data.entity

import com.google.gson.annotations.SerializedName

/**
 * Created by vincentpaing on 8/24/17.
 */
data class AvatarPackEntity(
    val packId: Int,
    val packName: String,
    val price: Int,
    val hasAlreadyBought: Boolean,
    val imgUrl: String
)
