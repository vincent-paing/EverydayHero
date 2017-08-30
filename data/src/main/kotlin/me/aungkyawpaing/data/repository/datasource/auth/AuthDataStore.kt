package me.aungkyawpaing.data.repository.datasource.auth

import io.reactivex.Observable
import me.aungkyawpaing.data.entity.HeroEntity
import me.aungkyawpaing.data.entity.LoginEntity
import me.aungkyawpaing.data.entity.LoginStatusEntity

/**
 * Created by vincentpaing on 8/1/17.
 */
interface AuthDataStore {

  fun login(authCode: String): Observable<LoginEntity>

  fun logout(): Observable<Unit>

  fun getLoginStatus(): Observable<LoginStatusEntity>
}