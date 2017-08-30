package me.aungkyawpaing.data.entity.mapper

import com.aungkyawpaing.domain.model.LoginStatusModel
import me.aungkyawpaing.data.entity.LoginStatusEntity

/**
 * Created by vincentpaing on 8/27/17.
 */
object LoginStatusEntityMapper : BaseMapper<LoginStatusEntity, LoginStatusModel>() {

  override fun transform(obj: LoginStatusEntity): LoginStatusModel {
    return LoginStatusModel(obj.isFirstTime, obj.isLoggedIn)
  }

}