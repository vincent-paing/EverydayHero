package me.aungkyawpaing.everydayhero.dagger.components

import dagger.Component
import me.aungkyawpaing.everydayhero.dagger.PerActivity
import me.aungkyawpaing.everydayhero.view.avatarpack.AvatarPackFragment

/**
 * Created by vincentpaing on 8/24/17.
 */
@PerActivity
@Component(dependencies = arrayOf(AppComponent::class))
interface AvatarPackFragmentComponent {

  fun inject(avatarPackFragment: AvatarPackFragment)

}