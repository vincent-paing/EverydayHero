package me.aungkyawpaing.data.executor

import com.aungkyawpaing.domain.executor.ThreadExecutor
import io.reactivex.annotations.NonNull
import java.util.concurrent.LinkedBlockingQueue
import java.util.concurrent.ThreadFactory
import java.util.concurrent.ThreadPoolExecutor
import java.util.concurrent.TimeUnit.SECONDS
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by vincentpaing on 7/30/17.
 */

@Singleton class JobExecutor @Inject constructor() : ThreadExecutor {
  private val threadPoolExecutor: ThreadPoolExecutor

  init {
    this.threadPoolExecutor = ThreadPoolExecutor(3, 5, 10, SECONDS,
        LinkedBlockingQueue<Runnable>(),
        JobThreadFactory())
  }

  override fun execute(@NonNull runnable: Runnable) {
    this.threadPoolExecutor.execute(runnable)
  }

  private class JobThreadFactory : ThreadFactory {
    private var counter = 0

    override fun newThread(@NonNull runnable: Runnable): Thread {
      return Thread(runnable, "android_" + counter++)
    }
  }
}