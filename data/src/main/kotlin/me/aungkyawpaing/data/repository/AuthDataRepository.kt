package me.aungkyawpaing.data.repository

import com.aungkyawpaing.domain.model.LoginModel
import com.aungkyawpaing.domain.model.LoginStatusModel
import com.aungkyawpaing.domain.repository.AuthRepository
import io.reactivex.Observable
import me.aungkyawpaing.data.entity.mapper.LoginEntityMapper
import me.aungkyawpaing.data.entity.mapper.LoginStatusEntityMapper
import me.aungkyawpaing.data.repository.datasource.auth.AuthDataStoreFactory
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by vincentpaing on 8/26/17.
 */
@Singleton
class AuthDataRepository @Inject constructor(
    val authDataStoreFactory: AuthDataStoreFactory
) : AuthRepository {

  override fun checkLoginStatus(): Observable<LoginStatusModel> {
    return authDataStoreFactory.createLocalDataStore().getLoginStatus().map {
      LoginStatusEntityMapper.transform(it)
    }
  }

  override fun login(authCode: String): Observable<LoginModel> {
    return authDataStoreFactory.createCloudDataStore().login(authCode).map {
      LoginEntityMapper.transform(it)
    }
  }

  override fun logout(): Observable<Unit> {
    return authDataStoreFactory.createCloudDataStore().logout()
  }

}