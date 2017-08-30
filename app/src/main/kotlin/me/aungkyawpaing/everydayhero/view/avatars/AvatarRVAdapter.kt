package me.aungkyawpaing.everydayhero.view.avatars

import android.content.Context
import android.view.ViewGroup
import me.aungkyawpaing.everydayhero.model.Avatar
import me.aungkyawpaing.everydayhero.view.core.BaseHashMapRecyclerViewAdapter
import javax.inject.Inject

/**
 * Created by vincentpaing on 8/28/17.
 */
class AvatarRVAdapter @Inject constructor(
    context: Context) : BaseHashMapRecyclerViewAdapter<Avatar, VHAvatar>(context) {
  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VHAvatar {
    return VHAvatar.newInstance(parent, onItemClick)
  }

}