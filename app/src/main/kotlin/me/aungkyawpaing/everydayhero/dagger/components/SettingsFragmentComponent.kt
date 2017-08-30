package me.aungkyawpaing.everydayhero.dagger.components

import dagger.Component
import me.aungkyawpaing.everydayhero.dagger.PerActivity
import me.aungkyawpaing.everydayhero.dagger.modules.QuestModule
import me.aungkyawpaing.everydayhero.view.quest.QuestFragment
import me.aungkyawpaing.everydayhero.view.settings.SettingsFragment

/**
 * Created by vincentpaing on 8/28/17.
 */
@PerActivity
@Component(dependencies = arrayOf(AppComponent::class),
    modules = arrayOf(QuestModule::class))
interface SettingsFragmentComponent {

  fun inject(settingsFragment: SettingsFragment)
}