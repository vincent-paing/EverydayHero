package me.aungkyawpaing.data.network.retrofit.responses.mapper

import me.aungkyawpaing.data.entity.QuestEntitiy
import me.aungkyawpaing.data.entity.mapper.BaseMapper
import me.aungkyawpaing.data.network.retrofit.responses.GetQuestListResponse

/**
 * Created by vincentpaing on 8/5/17.
 */
object GetQuestListResponseMapper : BaseMapper<GetQuestListResponse, QuestEntitiy>() {

  override fun transform(obj: GetQuestListResponse): QuestEntitiy {
    return QuestEntitiy(obj.quest_id, obj.description, obj.experience_point, obj.finished)
  }

}