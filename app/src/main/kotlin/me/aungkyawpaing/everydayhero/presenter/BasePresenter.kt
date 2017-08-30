package me.aungkyawpaing.everydayhero.presenter

/**
 * Created by vincentpaing on 7/30/17.
 */
abstract class BasePresenter<T> : Presenter {

//  var view: T? = null

  abstract fun init()

  abstract fun setView(view: T)
}
