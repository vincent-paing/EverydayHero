package me.aungkyawpaing.everydayhero.view.quest

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import me.aungkyawpaing.everydayhero.R
import me.aungkyawpaing.everydayhero.model.Quest
import me.aungkyawpaing.everydayhero.view.core.BaseHashMapRecyclerViewAdapter
import me.aungkyawpaing.everydayhero.view.core.BaseRecyclerViewAdapter
import javax.inject.Inject


/**
 * Created by vincentpaing on 8/6/17.
 */
class QuestAdapter @Inject constructor(
    context: Context) : BaseHashMapRecyclerViewAdapter<Quest, VHQuest>(
    context) {

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VHQuest {
    return VHQuest(layoutInflater.inflate(R.layout.item_quest, parent, false), onItemClick)
  }

}
