package me.aungkyawpaing.data.entity

/**
 * Created by vincentpaing on 8/28/17.
 */
data class AvatarEntity(
    val avatarId: Int,
    val packId: Int,
    val url: String,
    val isUnlocked: Boolean,
    val requireLevel: Int,
    val isCurrentlyUsed: Boolean
)
