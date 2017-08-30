package me.aungkyawpaing.everydayhero.model

import me.aungkyawpaing.everydayhero.view.core.BaseHashMapRecyclerViewAdapter.MappableItem

/**
 * Created by vincentpaing on 8/5/17.
 */
data class Quest constructor(val questId: Int,
    val description: String,
    val experiencePoint: Long,
    val isFinished: Boolean,
    var isLoading: Boolean = false,
    override val getID: () -> String = { questId.toString() }) : MappableItem