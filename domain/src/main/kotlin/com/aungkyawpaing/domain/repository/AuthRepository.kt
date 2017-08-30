package com.aungkyawpaing.domain.repository

import com.aungkyawpaing.domain.model.HeroModel
import com.aungkyawpaing.domain.model.LoginModel
import com.aungkyawpaing.domain.model.LoginStatusModel
import io.reactivex.Observable

/**
 * Created by vincentpaing on 8/26/17.
 */
interface AuthRepository {

  fun checkLoginStatus(): Observable<LoginStatusModel>

  fun login(authCode: String): Observable<LoginModel>

  fun logout(): Observable<Unit>

}