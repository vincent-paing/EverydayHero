package me.aungkyawpaing.everydayhero.dagger.components

import dagger.Component
import me.aungkyawpaing.everydayhero.dagger.PerActivity
import me.aungkyawpaing.everydayhero.view.avatars.AvatarFragment

/**
 * Created by vincentpaing on 8/28/17.
 */
@PerActivity
@Component(dependencies = arrayOf(AppComponent::class))
interface AvatarFragmentComponent {

  fun inject(avatarFragment: AvatarFragment)

}