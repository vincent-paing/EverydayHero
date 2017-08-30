package me.aungkyawpaing.everydayhero.view.avatarpack

import android.support.v4.content.ContextCompat
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.squareup.phrase.Phrase
import kotlinx.android.synthetic.main.item_avatar_pack.view.btn_buy
import kotlinx.android.synthetic.main.item_avatar_pack.view.iv_pack
import kotlinx.android.synthetic.main.item_avatar_pack.view.tv_pack_name
import me.aungkyawpaing.everydayhero.GlideApp
import me.aungkyawpaing.everydayhero.R
import me.aungkyawpaing.everydayhero.components.SquareImageView
import me.aungkyawpaing.everydayhero.model.AvatarPack
import me.aungkyawpaing.everydayhero.view.core.BaseViewHolder

/**
 * Created by vincentpaing on 8/24/17.
 */
class VHAvatarPack constructor(itemView: View,
    val avatarPackItemClick: ((AvatarPack, Int) -> Unit)?) : BaseViewHolder<AvatarPack>(itemView,
    avatarPackItemClick) {

  val tvPackName: TextView = itemView.tv_pack_name
  val ivPack: SquareImageView = itemView.iv_pack
  val btnBuy: TextView = itemView.btn_buy


  companion object {
    fun newInstance(parent: ViewGroup,
        avatarPackItemClick: ((AvatarPack, Int) -> Unit)?): VHAvatarPack {
      val rootView = LayoutInflater.from(parent.context).inflate(getLayoutResourceId(), parent,
          false)
      return VHAvatarPack(rootView, avatarPackItemClick)
    }

    private fun getLayoutResourceId(): Int = R.layout.item_avatar_pack
  }

  override fun bind(item: AvatarPack) {
    tvPackName.text = item.packName

    GlideApp.with(itemView.context)
        .load(item.imgUrl)
        .into(ivPack)

    if (item.hasAlreadyBought) {
      btnBuy.text = "Purchased"
      btnBuy.setBackgroundResource(R.drawable.bg_btn_bought)
      btnBuy.setTextColor(ContextCompat.getColor(itemView.context, R.color.fruit_salad))
      btnBuy.isClickable = false
    } else {
      btnBuy.text = Phrase.from(itemView.context, R.string.format_coin)
          .put("coin", item.price.toString())
          .format()
      btnBuy.setBackgroundResource(R.drawable.bg_btn_buy)
      btnBuy.setTextColor(ContextCompat.getColor(itemView.context, R.color.primary))
      btnBuy.setOnClickListener {
        avatarPackItemClick?.invoke(item, adapterPosition)
      }
    }
  }


}