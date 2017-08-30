package me.aungkyawpaing.everydayhero.dagger.modules

import android.content.Context
import dagger.Module
import dagger.Provides
import me.aungkyawpaing.data.cache.AuthCache
import me.aungkyawpaing.data.cache.HeroCache
import me.aungkyawpaing.data.network.retrofit.EverydayHeroApi
import me.aungkyawpaing.data.network.retrofit.URL
import me.aungkyawpaing.data.network.retrofit.interceptor.AuthInterceptor
import me.aungkyawpaing.everydayhero.utils.Constants
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.CallAdapter
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named
import javax.inject.Singleton

/**
 * Created by vincentpaing on 7/30/17.
 */
@Module
class RetrofitModule(private val context: Context) {

  @Provides
  @Named(Constants.NAME_BASE_URL) internal fun provideBaseUrl(): String {
    return URL.BASE_URL
  }

  @Provides
  @Singleton
  fun provideGsonConverter(): Converter.Factory {
    return GsonConverterFactory.create()
  }

  @Provides
  @Singleton
  fun provideCallAdapterFactory(): CallAdapter.Factory {
    return RxJava2CallAdapterFactory.create()
  }


  @Provides
  fun provideAuthInterceptor(authCache: AuthCache
      , heroCache: HeroCache): AuthInterceptor {
    return AuthInterceptor(authCache, heroCache)
  }

  @Provides
  @Singleton
  fun provideOkHttpClient(authInterceptor: AuthInterceptor): OkHttpClient {
    val httpLoggingInterceptor = HttpLoggingInterceptor()
    httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BASIC
    return OkHttpClient.Builder()
        .addInterceptor(authInterceptor)
        .addInterceptor(httpLoggingInterceptor).build()
  }

  @Provides
  @Singleton
  fun provideRetrofit(converter: Converter.Factory,
      callAdapterFactory: CallAdapter.Factory, okHttpClient: OkHttpClient,
      @Named(Constants.NAME_BASE_URL) baseUrl: String): Retrofit {
    return Retrofit.Builder().baseUrl(baseUrl)
        .addConverterFactory(converter)
        .addCallAdapterFactory(callAdapterFactory)
        .client(okHttpClient)
        .build()
  }

  @Provides
  @Singleton
  fun provideEveryDayHeroApi(
      retrofit: Retrofit): EverydayHeroApi {
    return retrofit.create(EverydayHeroApi::class.java)
  }
}
