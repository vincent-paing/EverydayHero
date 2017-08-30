package me.aungkyawpaing.data.entity

/**
 * Created by vincentpaing on 7/30/17.
 */
data class HeroEntity(
    val heroId: String,
    val name: String,
    val level: Int,
    val experiencePoint: Long,
    val nextExperiencePoint: Long,
    val avatarUrl: String,
    val point: Int,
    val rank: String
)