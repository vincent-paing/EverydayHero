package me.aungkyawpaing.data.network.retrofit.interceptor

import me.aungkyawpaing.data.cache.AuthCache
import me.aungkyawpaing.data.cache.HeroCache
import okhttp3.Interceptor
import okhttp3.Interceptor.Chain
import okhttp3.Response

/**
 * Created by vincentpaing on 8/18/17.
 */
class AuthInterceptor constructor(
    val authCache: AuthCache,
    val heroCache: HeroCache) : Interceptor {

  override fun intercept(chain: Chain?): Response {
    val originalRequest = chain!!.request()

    val token = authCache.getAccessToken()
    val hero_id = heroCache.getHeroID()

    if (token != null && hero_id != null) {
      val urlBuilder = originalRequest?.url()?.newBuilder()?.addQueryParameter("auth_token",
          token)?.addQueryParameter("hero_id", hero_id)
      val newRequest = originalRequest?.newBuilder()?.url(urlBuilder?.build())?.build()

      return chain.proceed(newRequest)
    } else {
      return chain.proceed(originalRequest)
    }
  }

}