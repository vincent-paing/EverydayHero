package me.aungkyawpaing.everydayhero.model.mapper

import com.aungkyawpaing.domain.model.QuestModel
import me.aungkyawpaing.data.entity.mapper.BaseMapper
import me.aungkyawpaing.everydayhero.model.Quest

/**
 * Created by vincentpaing on 8/5/17.
 */
object QuestMapper : BaseMapper<QuestModel, Quest>() {

  override fun transform(obj: QuestModel): Quest {
    return Quest(obj.questId, obj.description, obj.experiencePoint, obj.isFinished)
  }

}