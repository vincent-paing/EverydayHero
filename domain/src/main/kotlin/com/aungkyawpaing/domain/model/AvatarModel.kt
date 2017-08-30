package com.aungkyawpaing.domain.model

/**
 * Created by vincentpaing on 8/28/17.
 */
data class AvatarModel(
    val avatarId: Int,
    val packId: Int,
    val url: String,
    val isUnlocked: Boolean,
    val requireLevel: Int,
    val isCurrentlyUsed: Boolean
)

