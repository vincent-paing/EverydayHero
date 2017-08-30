package me.aungkyawpaing.everydayhero.dagger.components

import dagger.Component
import me.aungkyawpaing.everydayhero.dagger.PerActivity
import me.aungkyawpaing.everydayhero.dagger.modules.QuestModule
import me.aungkyawpaing.everydayhero.view.quest.QuestFragment

/**
 * Created by vincentpaing on 8/5/17.
 */
@PerActivity @Component(dependencies = arrayOf(AppComponent::class),
    modules = arrayOf(QuestModule::class))
interface QuestFragmentComponent {

  fun inject(questFragment: QuestFragment)
}