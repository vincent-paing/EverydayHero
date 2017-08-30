package me.aungkyawpaing.data.repository.datasource.quest

import android.util.Log
import io.reactivex.Observable
import me.aungkyawpaing.data.cache.HeroCache
import me.aungkyawpaing.data.entity.CompleteQuestEntity
import me.aungkyawpaing.data.entity.QuestEntitiy
import me.aungkyawpaing.data.network.QuestNetwork
import javax.inject.Inject

/**
 * Created by vincentpaing on 8/5/17.
 */
class QuestNetworkDataStore
@Inject constructor(private val questNetwork: QuestNetwork,
    private val heroCache: HeroCache) : QuestDataStore {

  override fun getQuests(): Observable<List<QuestEntitiy>> {
    return questNetwork.getQuests(heroCache.get()!!.heroId)
  }

  override fun completeQuest(questId: Int): Observable<CompleteQuestEntity> {
    return questNetwork.completeQuest(heroCache.get()!!.heroId, questId).doOnNext {
      heroCache.put(it.heroEntity)
    }
  }

}