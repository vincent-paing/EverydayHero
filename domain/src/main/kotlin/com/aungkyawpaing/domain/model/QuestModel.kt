package com.aungkyawpaing.domain.model

/**
 * Created by vincentpaing on 8/5/17.
 */
data class QuestModel(
    val questId: Int,
    val description: String,
    val experiencePoint: Long,
    val isFinished: Boolean
)