package me.aungkyawpaing.everydayhero.dagger.components

import dagger.Component
import me.aungkyawpaing.everydayhero.dagger.PerActivity
import me.aungkyawpaing.everydayhero.view.main.MainActivity

/**
 * Created by vincentpaing on 8/8/17.
 */
@PerActivity @Component(dependencies = arrayOf(AppComponent::class))
interface MainActivityComponent {

  fun inject(mainActivity: MainActivity)
}