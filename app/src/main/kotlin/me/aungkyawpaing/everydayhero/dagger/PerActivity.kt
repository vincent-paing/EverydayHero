package me.aungkyawpaing.everydayhero.dagger

import javax.inject.Scope

/**
 * Created by vincentpaing on 7/30/17.
 */

/**
 * A scoping annotation to permit objects whose lifetime should
 * conform to the life of the activity to be memorized in the
 * correct component.
 */
@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class PerActivity