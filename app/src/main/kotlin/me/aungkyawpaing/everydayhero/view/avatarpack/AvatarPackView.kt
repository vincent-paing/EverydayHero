package me.aungkyawpaing.everydayhero.view.avatarpack

import me.aungkyawpaing.everydayhero.model.AvatarPack
import me.aungkyawpaing.everydayhero.model.BuyAvatarPack
import me.aungkyawpaing.everydayhero.view.core.LoadingView

/**
 * Created by vincentpaing on 8/24/17.
 */
interface AvatarPackView : LoadingView {

  fun showAvatarPacks(avatarPacks: List<AvatarPack>)

  fun onBuyAvatarPackSuccess(buyAvatarPack: BuyAvatarPack)

  fun showBuyAvatarPackLoading()

  fun hideBuyAvatarPackLoading()

}