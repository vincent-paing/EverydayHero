package com.aungkyawpaing.domain.repository

import com.aungkyawpaing.domain.model.CompleteQuestModel
import com.aungkyawpaing.domain.model.QuestModel
import io.reactivex.Observable

/**
 * Created by vincentpaing on 8/5/17.
 */
interface QuestRepository {

  fun getQuests(): Observable<List<QuestModel>>

  fun completeQuest(questID: Int): Observable<CompleteQuestModel>
}