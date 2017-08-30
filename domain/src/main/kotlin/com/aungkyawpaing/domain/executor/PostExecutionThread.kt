package com.aungkyawpaing.domain.executor

import io.reactivex.Scheduler

/**
 * Created by vincentpaing on 7/30/17.
 */
interface PostExecutionThread {
  val scheduler: Scheduler
}