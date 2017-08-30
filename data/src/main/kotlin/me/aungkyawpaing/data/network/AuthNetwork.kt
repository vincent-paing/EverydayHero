package me.aungkyawpaing.data.network

import io.reactivex.Observable
import me.aungkyawpaing.data.entity.LoginEntity

/**
 * Created by vincentpaing on 8/26/17.
 */
interface AuthNetwork {

  fun login(authCode: String): Observable<LoginEntity>

  fun logout(): Observable<Unit>
}
