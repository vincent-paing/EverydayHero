package me.aungkyawpaing.data.network.retrofit.impl

import io.reactivex.Observable
import me.aungkyawpaing.data.entity.CompleteQuestEntity
import me.aungkyawpaing.data.entity.QuestEntitiy
import me.aungkyawpaing.data.network.QuestNetwork
import me.aungkyawpaing.data.network.retrofit.NetworkRequestManager
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by vincentpaing on 8/5/17.
 */
@Singleton
class QuestNetworkRetrofitImpl
@Inject constructor(val networkRequestManager: NetworkRequestManager) : QuestNetwork {

  override fun getQuests(heroId: String): Observable<List<QuestEntitiy>> {
    return networkRequestManager.getQuestList()
  }

  override fun completeQuest(heroId: String, questId: Int): Observable<CompleteQuestEntity> {
    return networkRequestManager.completeQuest(heroId, questId)
  }
}