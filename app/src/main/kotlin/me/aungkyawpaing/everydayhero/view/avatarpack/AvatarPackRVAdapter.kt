package me.aungkyawpaing.everydayhero.view.avatarpack

import android.content.Context
import android.view.ViewGroup
import me.aungkyawpaing.everydayhero.model.AvatarPack
import me.aungkyawpaing.everydayhero.view.core.BaseHashMapRecyclerViewAdapter
import me.aungkyawpaing.everydayhero.view.core.BaseRecyclerViewAdapter
import javax.inject.Inject

/**
 * Created by vincentpaing on 8/24/17.
 */
class AvatarPackRVAdapter @Inject constructor(
    context: Context) : BaseHashMapRecyclerViewAdapter<AvatarPack, VHAvatarPack>(context) {

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VHAvatarPack {
    return VHAvatarPack.newInstance(parent, onItemClick)
  }

}