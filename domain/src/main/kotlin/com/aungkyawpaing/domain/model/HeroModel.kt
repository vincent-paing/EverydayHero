package com.aungkyawpaing.domain.model

/**
 * Created by vincentpaing on 8/1/17.
 */
data class HeroModel(
    val hero_id: String,
    val name: String,
    val level: Int,
    val experiencePoint: Long,
    val nextExperiencePoint: Long,
    val avatarUrl: String,
    val point: Int,
    val rank: String

)