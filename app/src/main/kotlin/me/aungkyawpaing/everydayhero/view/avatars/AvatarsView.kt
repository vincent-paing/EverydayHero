package me.aungkyawpaing.everydayhero.view.avatars

import android.content.Context
import me.aungkyawpaing.everydayhero.model.Avatar

/**
 * Created by vincentpaing on 8/28/17.
 */
interface AvatarsView {

  fun showAvatars(avatarList: List<Avatar>)

  fun showAvatarsLoading()

  fun hideAvatarsLoading()

  fun showAvatarsRetry()

  fun hideAvatarsRetry()

  fun showError(message: String)

  fun context(): Context

  fun showSelectAvatar(avatarId: String)

  fun showUpdateAvatarSuccess()
}