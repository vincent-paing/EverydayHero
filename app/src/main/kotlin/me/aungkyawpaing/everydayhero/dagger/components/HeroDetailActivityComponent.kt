package me.aungkyawpaing.everydayhero.dagger.components

import dagger.Component
import me.aungkyawpaing.everydayhero.dagger.PerActivity
import me.aungkyawpaing.everydayhero.view.herodetail.HeroDetailActivity
import me.aungkyawpaing.everydayhero.view.main.MainActivity

/**
 * Created by vincentpaing on 8/20/17.
 */
@PerActivity
@Component(dependencies = arrayOf(AppComponent::class))
interface HeroDetailActivityComponent {

  fun inject(heroDetailActivity: HeroDetailActivity)
}