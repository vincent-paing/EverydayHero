package me.aungkyawpaing.everydayhero.view.settings

import android.app.Activity
import android.app.ProgressDialog
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.squareup.phrase.Phrase
import kotlinx.android.synthetic.main.fragment_settings.iv_hero
import kotlinx.android.synthetic.main.fragment_settings.layout_edit_avatar
import kotlinx.android.synthetic.main.fragment_settings.progress_bar_hero_exp
import kotlinx.android.synthetic.main.fragment_settings.toolbar
import kotlinx.android.synthetic.main.fragment_settings.tv_hero_lvl_exp
import kotlinx.android.synthetic.main.fragment_settings.tv_hero_name
import kotlinx.android.synthetic.main.fragment_settings.tv_sign_out
import me.aungkyawpaing.everydayhero.GlideApp
import me.aungkyawpaing.everydayhero.R
import me.aungkyawpaing.everydayhero.dagger.components.DaggerSettingsFragmentComponent
import me.aungkyawpaing.everydayhero.model.Hero
import me.aungkyawpaing.everydayhero.presenter.HeroInfoPresenter
import me.aungkyawpaing.everydayhero.presenter.LogoutPresenter
import me.aungkyawpaing.everydayhero.presenter.SettingsPresenter
import me.aungkyawpaing.everydayhero.utils.showShortToast
import me.aungkyawpaing.everydayhero.view.avatars.AvatarActivity
import me.aungkyawpaing.everydayhero.view.core.BaseFragment
import me.aungkyawpaing.everydayhero.view.herodetail.HeroInfoView
import me.aungkyawpaing.everydayhero.view.login.LoginActivity
import javax.inject.Inject

/**
 * Created by vincentpaing on 8/28/17.
 */
class SettingsFragment : BaseFragment(), HeroInfoView, LogoutView, SettingsView {

  @Inject lateinit var heroPresenter: HeroInfoPresenter
  @Inject lateinit var logOutPresenter: LogoutPresenter
  @Inject lateinit var settingsPresenter: SettingsPresenter
  val logoutProgressDialog by lazy { ProgressDialog(activity) }

  val REQUEST_CODE = 500

  companion object {
    fun newInstance(): SettingsFragment {
      val settingsFragment = SettingsFragment()
      return settingsFragment
    }
  }

  override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
      savedInstanceState: Bundle?): View? {
    val rootView = inflater?.inflate(R.layout.fragment_settings, container, false)

    initDagger()

    if (savedInstanceState == null) {
      logOutPresenter.setView(this)
      logOutPresenter.init()
      heroPresenter.setView(this)
      heroPresenter.init()
      settingsPresenter.setView(this)
      settingsPresenter.init()
    }

    return rootView
  }

  override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    setupLayout()
    heroPresenter.loadHero()
  }

  private fun initDagger() {
    DaggerSettingsFragmentComponent.builder()
        .appComponent(appComponent)
        .build()
        .inject(this)
  }

  private fun setupLayout() {
    toolbar.title = "Settings"
    tv_sign_out.setOnClickListener {
      logOutPresenter.logout()
    }
    layout_edit_avatar.setOnClickListener {
      settingsPresenter.renderSelectAvatar()
    }
  }

  override fun showReminderTimeSelector() {
  }

  override fun showSelectAvatar() {
    val intent = Intent(activity, AvatarActivity::class.java)
    startActivityForResult(intent, REQUEST_CODE)
  }

  override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
    if (requestCode == REQUEST_CODE && resultCode == Activity.RESULT_OK) {
      heroPresenter.loadHero()
    }
  }

  override fun showLogoutSuccess() {
    LoginActivity.start(activity)
    activity.finish()
  }


  override fun showLogoutLoading() {
    logoutProgressDialog.setMessage("Logging out")
    logoutProgressDialog.isIndeterminate = false
    logoutProgressDialog.show()
  }

  override fun hideLogoutLoading() {
    logoutProgressDialog.hide()
  }

  override fun showLogoutRetry() {
  }

  override fun hideLogoutRetry() {
  }

  override fun showHeroInfo(hero: Hero) {
    progress_bar_hero_exp.max = hero.nextExperiencePoint.toInt()
    progress_bar_hero_exp.progress = hero.experiencePoint.toInt()

    GlideApp.with(this).load(hero.avatarUrl)
        .placeholder(R.drawable.ic_cricle_placeholder)
        .circleCrop()
        .into(iv_hero)
    tv_hero_name.text = hero.name
    tv_hero_lvl_exp.text = Phrase.from(context(), R.string.format_hero_lvl)
        .put("lvl", hero.level)
        .put("title", hero.rank)
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

  override fun showError(message: String) {
    showShortToast(message)
  }

  override fun context(): Context = context

  override fun onDestroy() {
    super.onDestroy()
    heroPresenter.destroy()
    logOutPresenter.destroy()
    settingsPresenter.destroy()
  }

}