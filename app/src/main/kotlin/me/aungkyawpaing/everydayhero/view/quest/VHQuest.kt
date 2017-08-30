package me.aungkyawpaing.everydayhero.view.quest

import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import kotlinx.android.synthetic.main.item_quest.view.checkbox_quest
import kotlinx.android.synthetic.main.item_quest.view.container_checkbox
import kotlinx.android.synthetic.main.item_quest.view.iv_share
import kotlinx.android.synthetic.main.item_quest.view.progress_bar_quest
import kotlinx.android.synthetic.main.item_quest.view.tv_description
import me.aungkyawpaing.everydayhero.model.Quest
import me.aungkyawpaing.everydayhero.utils.setVisible
import me.aungkyawpaing.everydayhero.view.core.BaseViewHolder

/**
 * Created by vincentpaing on 8/6/17.
 */
class VHQuest constructor(itemView: View,
    val questItemClick: ((Quest, Int) -> Unit)?) : BaseViewHolder<Quest>(itemView, questItemClick) {

  val checkBoxFinish: CheckBox = itemView.checkbox_quest
  val checkBoxLayout: ViewGroup = itemView.container_checkbox
  val tvDescription: TextView = itemView.tv_description
  val progressBar: ProgressBar = itemView.progress_bar_quest
  val ivShare: ImageView = itemView.iv_share

  override fun bind(item: Quest) {

    with(item) {
      progressBar.setVisible(isLoading)
      checkBoxFinish.setVisible(!isLoading)
      ivShare.setVisible(isFinished)

      checkBoxFinish.isChecked = isFinished
      if (!checkBoxFinish.isChecked)
        checkBoxLayout.setOnClickListener { questItemClick?.invoke(item, adapterPosition) }
      else
        checkBoxLayout.setOnClickListener(null)


      tvDescription.text = description
    }
  }

}
