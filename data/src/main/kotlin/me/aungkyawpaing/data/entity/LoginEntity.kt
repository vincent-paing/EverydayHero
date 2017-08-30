package me.aungkyawpaing.data.entity

/**
 * Created by vincentpaing on 8/26/17.
 */
data class LoginEntity(
    val heroEntity: HeroEntity,
    val isFirstTime: Boolean,
    val authToken: String
)