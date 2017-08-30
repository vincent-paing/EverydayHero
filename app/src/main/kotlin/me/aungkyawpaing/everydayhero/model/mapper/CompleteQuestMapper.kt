package me.aungkyawpaing.everydayhero.model.mapper

import com.aungkyawpaing.domain.model.CompleteQuestModel
import me.aungkyawpaing.data.entity.mapper.BaseMapper
import me.aungkyawpaing.everydayhero.model.CompleteQuest

/**
 * Created by vincentpaing on 8/16/17.
 */
object CompleteQuestMapper : BaseMapper<CompleteQuestModel, CompleteQuest>() {

  override fun transform(obj: CompleteQuestModel): CompleteQuest {
    return CompleteQuest(obj.doesLevelUp)
  }


}