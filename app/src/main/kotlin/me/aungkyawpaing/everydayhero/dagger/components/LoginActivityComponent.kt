package me.aungkyawpaing.everydayhero.dagger.components

import dagger.Component
import me.aungkyawpaing.everydayhero.dagger.PerActivity
import me.aungkyawpaing.everydayhero.dagger.modules.AuthModule
import me.aungkyawpaing.everydayhero.view.login.LoginActivity

/**
 * Created by vincentpaing on 8/4/17.
 */
@PerActivity @Component(dependencies = arrayOf(AppComponent::class),
    modules = arrayOf(AuthModule::class))
interface LoginActivityComponent {

  fun inject(loginActivity: LoginActivity)
}