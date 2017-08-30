package com.aungkyawpaing.domain.model

/**
 * Created by vincentpaing on 8/24/17.
 */
data class AvatarPackModel(
    val packId: Int,
    val packName: String,
    val price: Int,
    val hasAlreadyBought: Boolean,
    val imgUrl: String
)