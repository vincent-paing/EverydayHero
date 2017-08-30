package me.aungkyawpaing.everydayhero.model.mapper

import com.aungkyawpaing.domain.model.LoginStatusModel
import me.aungkyawpaing.data.entity.mapper.BaseMapper
import me.aungkyawpaing.everydayhero.model.LoginStatus

/**
 * Created by vincentpaing on 8/27/17.
 */
object LoginStatusMapper : BaseMapper<LoginStatusModel, LoginStatus>() {

  override fun transform(obj: LoginStatusModel): LoginStatus {
    return LoginStatus(obj.isFirstTime, obj.isLoggedIn)
  }

}