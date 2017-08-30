package me.aungkyawpaing.data.network.retrofit.responses

/**
 * Created by vincentpaing on 8/5/17.
 */
data class GetQuestListResponse(
    val quest_id: Int,
    val description: String,
    val experience_point: Long,
    val finished: Boolean
)