package me.aungkyawpaing.everydayhero.view.quest

import android.content.Context
import com.aungkyawpaing.domain.model.HeroModel
import me.aungkyawpaing.everydayhero.model.Hero
import me.aungkyawpaing.everydayhero.model.Quest
import me.aungkyawpaing.everydayhero.view.core.LoadingView

/**
 * Created by vincentpaing on 8/5/17.
 */
interface QuestView {

  fun showQuests(questList: List<Quest>)

  fun showCompleteQuestLoading(questID: Int)

  fun showCompleteQuestSuccess(questID: Int)

  fun showCompleteQuestFail(questID: Int)

  fun onQuestComplete()

  fun showQuestLoading()

  fun hideQuestLoading()

  fun showQuestRetry()

  fun hideQuestRetry()

  fun showError(message: String)

  fun context(): Context
}