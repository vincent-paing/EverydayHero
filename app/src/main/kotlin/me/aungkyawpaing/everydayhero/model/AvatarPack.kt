package me.aungkyawpaing.everydayhero.model

import me.aungkyawpaing.everydayhero.view.core.BaseHashMapRecyclerViewAdapter.MappableItem

/**
 * Created by vincentpaing on 8/24/17.
 */
data class AvatarPack(
    val packId: Int,
    val packName: String,
    val price: Int,
    val hasAlreadyBought: Boolean,
    val imgUrl: String,
    override val getID: () -> String = { packId.toString() }
) : MappableItem
