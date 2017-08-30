package me.aungkyawpaing.everydayhero.view.herodetail

import android.content.Context
import me.aungkyawpaing.everydayhero.model.Hero
import me.aungkyawpaing.everydayhero.view.core.LoadingView

/**
 * Created by vincentpaing on 8/19/17.
 */
interface HeroInfoView {

  fun showHeroInfo(hero: Hero)

  fun onQuestComplete()

  fun showHeroLoading()

  fun hideHeroLoading()

  fun showHeroRetry()

  fun hideHeroRetry()

  fun showError(message: String)

  fun context(): Context
}

