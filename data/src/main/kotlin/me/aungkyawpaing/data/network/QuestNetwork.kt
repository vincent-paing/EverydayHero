package me.aungkyawpaing.data.network

import io.reactivex.Observable
import me.aungkyawpaing.data.entity.CompleteQuestEntity
import me.aungkyawpaing.data.entity.QuestEntitiy

/**
 * Created by vincentpaing on 8/5/17.
 */
interface QuestNetwork {

  fun getQuests(heroId: String): Observable<List<QuestEntitiy>>

  fun completeQuest(heroId: String, questId: Int): Observable<CompleteQuestEntity>
}