package me.aungkyawpaing.everydayhero.view.herodetail

import android.content.Context
import android.content.Intent
import android.graphics.PorterDuff
import android.os.Bundle
import android.support.v4.content.res.ResourcesCompat
import com.squareup.phrase.Phrase
import kotlinx.android.synthetic.main.activity_hero_detail.iv_hero
import kotlinx.android.synthetic.main.activity_hero_detail.progress_bar_hero_exp
import kotlinx.android.synthetic.main.activity_hero_detail.tv_hero_lvl_exp
import kotlinx.android.synthetic.main.activity_hero_detail.tv_hero_name
import me.aungkyawpaing.everydayhero.GlideApp
import me.aungkyawpaing.everydayhero.R
import me.aungkyawpaing.everydayhero.dagger.components.DaggerHeroDetailActivityComponent
import me.aungkyawpaing.everydayhero.model.Hero
import me.aungkyawpaing.everydayhero.presenter.HeroInfoPresenter
import me.aungkyawpaing.everydayhero.utils.showShortToast
import me.aungkyawpaing.everydayhero.view.core.BaseActivity
import javax.inject.Inject

/**
 * Created by vincentpaing on 8/20/17.
 */
class HeroDetailActivity : BaseActivity(), HeroInfoView {

  @Inject lateinit var heroInfoPresenter: HeroInfoPresenter

  companion object {
    fun start(context: Context) {
      val intent = Intent(context, HeroDetailActivity::class.java)
      context.startActivity(intent)
    }
  }

  override val layoutResId: Int
    get() = R.layout.activity_hero_detail

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    initDagger()

    if (savedInstanceState == null) {
      heroInfoPresenter.setView(this)
      heroInfoPresenter.init()
      heroInfoPresenter.loadHero()
    }

    setupLayout()
  }

  private fun setupLayout() {
    val upArrow = ResourcesCompat.getDrawable(resources, R.drawable.abc_ic_ab_back_material, null)
    upArrow?.setColorFilter(ResourcesCompat.getColor(resources, android.R.color.black, null),
        PorterDuff.Mode.SRC_ATOP)
    supportActionBar?.setDisplayHomeAsUpEnabled(true)
    supportActionBar?.setHomeAsUpIndicator(upArrow)
  }

  private fun initDagger() {
    DaggerHeroDetailActivityComponent.builder()
        .appComponent(appComponent)
        .build().inject(this)
  }

  override fun onDestroy() {
    super.onDestroy()
    heroInfoPresenter.destroy()
  }


  override fun showHeroInfo(hero: Hero) {

    GlideApp.with(this).load(hero.avatarUrl)
        .placeholder(R.drawable.ic_cricle_placeholder)
        .circleCrop()
        .into(iv_hero)

    progress_bar_hero_exp.max = hero.nextExperiencePoint.toInt()
//    val animation = ObjectAnimator.ofInt(progress_bar_hero_exp, "progress",
//        hero.experiencePoint.toInt())
//    animation.duration = 100
//    animation.interpolator = DecelerateInterpolator()
//    animation.start()
    progress_bar_hero_exp.progress = hero.experiencePoint.toInt()


    tv_hero_name.text = hero.name
    tv_hero_lvl_exp.text = Phrase.from(context(), R.string.format_hero_lvl_and_exp)
        .put("lvl", hero.level)
        .put("title", "Rookie")
        .put("exp", hero.experiencePoint.toInt())
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

  override fun context(): Context = applicationContext

}