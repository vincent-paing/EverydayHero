package me.aungkyawpaing.everydayhero.view.avatars

import android.content.Context
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_avatars.progress_bar
import kotlinx.android.synthetic.main.fragment_avatars.rv_avatars
import me.aungkyawpaing.everydayhero.R
import me.aungkyawpaing.everydayhero.dagger.components.DaggerAvatarFragmentComponent
import me.aungkyawpaing.everydayhero.model.Avatar
import me.aungkyawpaing.everydayhero.presenter.AvatarPresenter
import me.aungkyawpaing.everydayhero.utils.setVisible
import me.aungkyawpaing.everydayhero.view.core.BaseFragment
import javax.inject.Inject

/**
 * Created by vincentpaing on 8/28/17.
 */
class AvatarFragment : BaseFragment(), AvatarsView {

  @Inject lateinit var avatarPresenter: AvatarPresenter
  @Inject lateinit var avatarAdapter: AvatarRVAdapter

  var lastSelectedId: String? = null

  var onSave: (() -> Unit)? = null

  companion object {
    fun newInstance(): AvatarFragment {
      return AvatarFragment()
    }
  }

  override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
      savedInstanceState: Bundle?): View? {
    val rootView = inflater?.inflate(R.layout.fragment_avatars, container, false)
    setHasOptionsMenu(true)
    initDagger()

    if (savedInstanceState == null) {
      avatarPresenter.setView(this)
      avatarPresenter.init()
    }

    return rootView
  }


  override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    setupLayout()
    avatarPresenter.loadAvatars()
  }


  private fun setupLayout() {
    avatarAdapter = AvatarRVAdapter(activity)
    avatarAdapter.onItemClick = { avatar, position ->
      avatarPresenter.selectAvatar(avatar.getID())
    }

    rv_avatars.layoutManager = GridLayoutManager(activity, 2)
    rv_avatars.adapter = avatarAdapter
  }

  private fun initDagger() {
    DaggerAvatarFragmentComponent.builder()
        .appComponent(appComponent)
        .build()
        .inject(this)
  }

  override fun showSelectAvatar(avatarId: String) {
    if (lastSelectedId != null) {
      avatarAdapter.setItem(
          avatarAdapter.getItem(lastSelectedId!!).copy(isSelected = false)
      )
    }
    avatarAdapter.setItem(
        avatarAdapter.getItem(avatarId).copy(isSelected = true)
    )
    lastSelectedId = avatarId
  }

  override fun showAvatars(avatarList: List<Avatar>) {
    rv_avatars.setVisible(true)
    for (item in avatarList) {
      if (item.isSelected) lastSelectedId = item.getID()
    }
    avatarAdapter.items = avatarList
  }

  override fun showAvatarsLoading() {
    progress_bar.setVisible(true)
    rv_avatars.setVisible(false)
  }

  override fun hideAvatarsLoading() {
    progress_bar.setVisible(false)
    rv_avatars.setVisible(true)
  }

  override fun showAvatarsRetry() {
  }

  override fun hideAvatarsRetry() {
  }

  override fun showError(message: String) {

  }

  override fun onCreateOptionsMenu(menu: Menu?, inflater: MenuInflater?) {
    super.onCreateOptionsMenu(menu, inflater)
    inflater?.inflate(R.menu.menu_fragment_avatar, menu)
  }

  override fun onOptionsItemSelected(item: MenuItem?): Boolean {
    when (item?.itemId) {
      R.id.action_save -> avatarPresenter.updateAvatar(Integer.parseInt(lastSelectedId))
    }
    return super.onOptionsItemSelected(item)
  }

  override fun showUpdateAvatarSuccess() {
    onSave?.invoke()
  }

  override fun onDestroy() {
    super.onDestroy()
    avatarPresenter.destroy()
  }

  override fun context(): Context = context
}