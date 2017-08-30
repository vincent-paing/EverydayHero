package me.aungkyawpaing.everydayhero.view.avatarpack

import android.app.ProgressDialog
import android.content.Context
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.squareup.phrase.Phrase
import kotlinx.android.synthetic.main.fragment_avatar_packs.collpasing_toolbar
import kotlinx.android.synthetic.main.fragment_avatar_packs.rv_avatar_packs
import me.aungkyawpaing.everydayhero.R
import me.aungkyawpaing.everydayhero.dagger.components.DaggerAvatarPackFragmentComponent
import me.aungkyawpaing.everydayhero.model.AvatarPack
import me.aungkyawpaing.everydayhero.model.BuyAvatarPack
import me.aungkyawpaing.everydayhero.model.Hero
import me.aungkyawpaing.everydayhero.presenter.AvatarPackPresenter
import me.aungkyawpaing.everydayhero.presenter.HeroInfoPresenter
import me.aungkyawpaing.everydayhero.utils.showShortToast
import me.aungkyawpaing.everydayhero.view.core.BaseFragment
import me.aungkyawpaing.everydayhero.view.herodetail.HeroInfoView
import javax.inject.Inject

/**
 * Created by vincentpaing on 8/24/17.
 */
class AvatarPackFragment : BaseFragment(), AvatarPackView, HeroInfoView {

  companion object {
    fun newInstance(): AvatarPackFragment {
      val avatarPackFragment = AvatarPackFragment()
      return avatarPackFragment
    }
  }

  @Inject lateinit var avatarPackPresenter: AvatarPackPresenter
  @Inject lateinit var avatarPackAdapter: AvatarPackRVAdapter
  @Inject lateinit var heroInfoPresenter: HeroInfoPresenter

  override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
      savedInstanceState: Bundle?): View? {
    val rootView = inflater?.inflate(R.layout.fragment_avatar_packs, container, false)

    initDagger()

    if (savedInstanceState == null) {
      avatarPackPresenter.setView(this)
      avatarPackPresenter.init()
      heroInfoPresenter.setView(this)
      heroInfoPresenter.init()
    }

    return rootView
  }

  override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    setupLayout()
    avatarPackPresenter.loadAvatarPacks()
  }

  private fun setupLayout() {
    avatarPackAdapter = AvatarPackRVAdapter(context)
    rv_avatar_packs.adapter = avatarPackAdapter
    rv_avatar_packs.layoutManager = GridLayoutManager(context, 2)
    collpasing_toolbar.title = "-"
    heroInfoPresenter.loadHero()

    avatarPackAdapter.onItemClick = { pack, _ ->
      avatarPackPresenter.buyAvatarPack(pack.packId)
    }
  }

  fun initDagger() {
    DaggerAvatarPackFragmentComponent.builder()
        .appComponent(appComponent).build()
        .inject(this)
  }

  override fun showLoading() {
    rv_avatar_packs.showShimmerAdapter()
  }

  override fun showAvatarPacks(avatarPacks: List<AvatarPack>) {
    avatarPackAdapter.items = avatarPacks
  }

  override fun hideLoading() {
    rv_avatar_packs.hideShimmerAdapter()
  }

  override fun showRetry() {
  }

  override fun hideRetry() {
  }

  override fun showError(message: String) {
    showShortToast(message)
  }

  override fun showHeroInfo(hero: Hero) {
    collpasing_toolbar.title = Phrase.from(context, R.string.format_coin)
        .put("coin", hero.point.toString())
        .format()
  }

  override fun onQuestComplete() {
  }

  override fun showHeroLoading() {
  }

  override fun hideHeroLoading() {
  }

  override fun showHeroRetry() {
  }

  override fun hideHeroRetry() {
  }


  override fun onBuyAvatarPackSuccess(buyAvatarPack: BuyAvatarPack) {
    avatarPackAdapter.setItem(
        avatarPackAdapter.getItem(buyAvatarPack.packId.toString()).copy(hasAlreadyBought = false))
    heroInfoPresenter.loadHero()
  }

  var dialog: ProgressDialog? = null

  override fun showBuyAvatarPackLoading() {
    dialog = ProgressDialog(activity)
    dialog?.isIndeterminate = true
    dialog?.setMessage("Loading..")
    dialog?.show()
  }

  override fun hideBuyAvatarPackLoading() {
    dialog?.hide()
  }


  override fun context(): Context = context

  override fun onDestroy() {
    super.onDestroy()
    avatarPackPresenter.destroy()
    heroInfoPresenter.destroy()
  }

}