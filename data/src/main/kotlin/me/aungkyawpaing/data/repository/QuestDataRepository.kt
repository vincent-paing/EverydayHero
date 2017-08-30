package me.aungkyawpaing.data.repository

import com.aungkyawpaing.domain.model.CompleteQuestModel
import com.aungkyawpaing.domain.model.QuestModel
import com.aungkyawpaing.domain.repository.QuestRepository
import io.reactivex.Observable
import me.aungkyawpaing.data.entity.mapper.CompleteQuestEntityMapper
import me.aungkyawpaing.data.entity.mapper.QuestEntityMapper
import me.aungkyawpaing.data.repository.datasource.hero.HeroCacheDataStore
import me.aungkyawpaing.data.repository.datasource.quest.QuestNetworkDataStore
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by vincentpaing on 8/5/17.
 */
@Singleton
class QuestDataRepository
@Inject constructor(
    val questNetworkDataStore: QuestNetworkDataStore)
  : QuestRepository {

  override fun getQuests(): Observable<List<QuestModel>> {
    return questNetworkDataStore.getQuests().map {
      QuestEntityMapper.transform(it)
    }
  }

  override fun completeQuest(questID: Int): Observable<CompleteQuestModel> {
    return questNetworkDataStore.completeQuest(questID).map {
      CompleteQuestEntityMapper.transform(it)
    }
  }
}