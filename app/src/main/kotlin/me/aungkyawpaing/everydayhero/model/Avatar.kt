package me.aungkyawpaing.everydayhero.model

import me.aungkyawpaing.everydayhero.view.core.BaseHashMapRecyclerViewAdapter.MappableItem

/**
 * Created by vincentpaing on 8/28/17.
 */
data class Avatar(
    val avatarId: Int,
    val packId: Int,
    val url: String,
    val isUnlocked: Boolean,
    val requireLevel: Int,
    val isSelected: Boolean,
    override val getID: () -> String = { avatarId.toString() }
) : MappableItem
