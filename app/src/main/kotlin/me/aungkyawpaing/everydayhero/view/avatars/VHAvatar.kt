package me.aungkyawpaing.everydayhero.view.avatars

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.squareup.phrase.Phrase
import kotlinx.android.synthetic.main.item_avatar.view.iv_avatar
import kotlinx.android.synthetic.main.item_avatar.view.iv_checked
import kotlinx.android.synthetic.main.item_avatar.view.layout_locked
import kotlinx.android.synthetic.main.item_avatar.view.tv_locked
import me.aungkyawpaing.everydayhero.GlideApp
import me.aungkyawpaing.everydayhero.R
import me.aungkyawpaing.everydayhero.model.Avatar
import me.aungkyawpaing.everydayhero.utils.setVisible
import me.aungkyawpaing.everydayhero.view.core.BaseViewHolder


/**
 * Created by vincentpaing on 8/28/17.
 */
class VHAvatar constructor(itemView: View,
    val avatarItemClick: ((Avatar, Int) -> Unit)?) : BaseViewHolder<Avatar>(itemView,
    avatarItemClick) {

  val tvLocked: TextView = itemView.tv_locked
  val layoutLocked: ViewGroup = itemView.layout_locked
  val ivCheck: ImageView = itemView.iv_checked
  val ivAvatar: ImageView = itemView.iv_avatar

  companion object {
    fun newInstance(parent: ViewGroup,
        avatarPackItemClick: ((Avatar, Int) -> Unit)?): VHAvatar {
      val rootView = LayoutInflater.from(parent.context).inflate(getLayoutResourceId(), parent,
          false)
      return VHAvatar(rootView, avatarPackItemClick)
    }

    private fun getLayoutResourceId(): Int = R.layout.item_avatar
  }

  override fun bind(item: Avatar) {
    with(item) {

      GlideApp.with(itemView.context)
          .load(url)
          .placeholder(R.drawable.ic_square_placeholder)
          .error(R.drawable.ic_square_placeholder)
          .into(ivAvatar)

      layoutLocked.setVisible(!isUnlocked)
      tvLocked.setVisible(!isUnlocked)
      ivCheck.setVisible(isSelected)
      if (!isUnlocked) {
        tvLocked.text = Phrase.from(itemView.context, R.string.format_unlock)
            .put("lvl", requireLevel.toString())
            .format()
        ivAvatar.setOnClickListener(null)
      } else {
        ivAvatar.setOnClickListener { avatarItemClick?.invoke(item, adapterPosition) }
      }


    }

  }
}