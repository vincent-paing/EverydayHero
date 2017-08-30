package me.aungkyawpaing.data.repository.datasource.quest

import io.reactivex.Observable
import me.aungkyawpaing.data.entity.CompleteQuestEntity
import me.aungkyawpaing.data.entity.QuestEntitiy

/**
 * Created by vincentpaing on 8/5/17.
 */
interface QuestDataStore {

  fun getQuests(): Observable<List<QuestEntitiy>>

  fun completeQuest(questId: Int): Observable<CompleteQuestEntity>
}