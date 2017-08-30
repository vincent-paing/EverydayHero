package me.aungkyawpaing.data.entity.mapper

import com.aungkyawpaing.domain.model.QuestModel
import me.aungkyawpaing.data.entity.QuestEntitiy

/**
 * Created by vincentpaing on 8/5/17.
 */
object QuestEntityMapper : BaseMapper<QuestEntitiy, QuestModel>() {

  override fun transform(questEntity: QuestEntitiy): QuestModel {
    return QuestModel(questEntity.questId, questEntity.description, questEntity.experiencePoint,
        questEntity.isFinished)
  }

}