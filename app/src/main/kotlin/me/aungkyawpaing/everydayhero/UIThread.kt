package me.aungkyawpaing.everydayhero

import com.aungkyawpaing.domain.executor.PostExecutionThread
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by vincentpaing on 7/30/17.
 */
@Singleton class UIThread @Inject internal constructor() : PostExecutionThread {

  override val scheduler: Scheduler
    get() = AndroidSchedulers.mainThread()
}
