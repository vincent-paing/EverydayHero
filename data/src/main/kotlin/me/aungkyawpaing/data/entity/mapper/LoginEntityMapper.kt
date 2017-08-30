package me.aungkyawpaing.data.entity.mapper

import com.aungkyawpaing.domain.model.LoginModel
import me.aungkyawpaing.data.entity.LoginEntity

/**
 * Created by vincentpaing on 8/26/17.
 */
object LoginEntityMapper : BaseMapper<LoginEntity, LoginModel>() {
  override fun transform(obj: LoginEntity): LoginModel {
    return LoginModel(obj.isFirstTime)
  }
}
