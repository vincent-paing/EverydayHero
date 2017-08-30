package me.aungkyawpaing.data.entity.mapper

import com.aungkyawpaing.domain.model.CompleteQuestModel
import me.aungkyawpaing.data.entity.CompleteQuestEntity
import me.aungkyawpaing.data.network.retrofit.responses.CompleteQuestResponse

/**
 * Created by vincentpaing on 8/16/17.
 */
object CompleteQuestEntityMapper : BaseMapper<CompleteQuestEntity, CompleteQuestModel>() {

  override fun transform(obj: CompleteQuestEntity): CompleteQuestModel {
    return CompleteQuestModel(obj.doesLevelUp)
  }

}