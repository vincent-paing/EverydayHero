package me.aungkyawpaing.everydayhero.view.quest

import android.content.Context
import android.os.Bundle
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.squareup.phrase.Phrase
import kotlinx.android.synthetic.main.fragment_quest.iv_hero
import kotlinx.android.synthetic.main.fragment_quest.layout_error
import kotlinx.android.synthetic.main.fragment_quest.progress_bar_hero_exp
import kotlinx.android.synthetic.main.fragment_quest.rv_quests
import kotlinx.android.synthetic.main.fragment_quest.tv_hero_lvl_exp
import kotlinx.android.synthetic.main.fragment_quest.tv_hero_name
import me.aungkyawpaing.everydayhero.GlideApp
import me.aungkyawpaing.everydayhero.R
import me.aungkyawpaing.everydayhero.dagger.components.DaggerQuestFragmentComponent
import me.aungkyawpaing.everydayhero.dagger.modules.QuestModule
import me.aungkyawpaing.everydayhero.model.Hero
import me.aungkyawpaing.everydayhero.model.Quest
import me.aungkyawpaing.everydayhero.presenter.HeroInfoPresenter
import me.aungkyawpaing.everydayhero.presenter.QuestPresenter
import me.aungkyawpaing.everydayhero.utils.setVisible
import me.aungkyawpaing.everydayhero.utils.showShortToast
import me.aungkyawpaing.everydayhero.view.core.BaseFragment
import me.aungkyawpaing.everydayhero.view.herodetail.HeroInfoView
import javax.inject.Inject

/**
 * Created by vincentpaing on 8/5/17.
 */
class QuestFragment : BaseFragment(), QuestView, HeroInfoView {

  companion object {
    fun newInstance(): QuestFragment {
      val questFragment = QuestFragment()
      return questFragment
    }
  }


  @Inject lateinit var questPresenter: QuestPresenter
  @Inject lateinit var heroPresenter: HeroInfoPresenter
  @Inject lateinit var questAdapter: QuestAdapter

  override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
      savedInstanceState: Bundle?): View? {
    val rootView = inflater?.inflate(R.layout.fragment_quest, container, false)

    initDagger()

    if (savedInstanceState == null) {
      questPresenter.setView(this)
      heroPresenter.setView(this)
      questPresenter.init()
      heroPresenter.setView(this)
    }

    return rootView
  }

  override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    setupLayout()
    heroPresenter.loadHero()
    questPresenter.loadQuestList()
  }

  private fun initDagger() {
    DaggerQuestFragmentComponent.builder()
        .appComponent(appComponent)
        .questModule(QuestModule(this))
        .build()
        .inject(this)
  }

  private fun setupLayout() {
    questAdapter = QuestAdapter(context)
    rv_quests.adapter = questAdapter
    rv_quests.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
    rv_quests.addItemDecoration(DividerItemDecoration(context, LinearLayoutManager.VERTICAL))
    questAdapter.onItemClick = { quest, _ ->
      questPresenter.completeQuest(quest.questId)
    }
    layout_error.setOnClickListener {
      questPresenter.loadQuestList()
    }
  }

  override fun showQuests(questList: List<Quest>) {
    questAdapter.items = questList
  }


  override fun showQuestLoading() {
    rv_quests.showShimmerAdapter()
  }

  override fun hideQuestLoading() {
    rv_quests.hideShimmerAdapter()
  }

  override fun showQuestRetry() {
    layout_error.setVisible(true)
  }

  override fun hideQuestRetry() {
    layout_error.setVisible(false)
  }


  override fun showCompleteQuestLoading(questID: Int) {
    questAdapter.setItem(questAdapter.getItem(questID.toString()).copy(isLoading = true))
  }

  override fun showCompleteQuestSuccess(questID: Int) {
    questAdapter.setItem(
        questAdapter.getItem(questID.toString()).copy(isLoading = false, isFinished = true))
  }

  override fun showCompleteQuestFail(questID: Int) {
    questAdapter.setItem(
        questAdapter.getItem(questID.toString()).copy(isLoading = false, isFinished = false))
  }

  override fun showError(message: String) {
    showShortToast(message)
  }

  override fun showHeroLoading() {
  }

  override fun hideHeroLoading() {
  }

  override fun showHeroRetry() {
  }

  override fun hideHeroRetry() {
  }


  override fun context(): Context {
    return context
  }

  override fun onQuestComplete() {
    heroPresenter.loadHero()
  }

  override fun showHeroInfo(hero: Hero) {
    progress_bar_hero_exp.max = hero.nextExperiencePoint.toInt()
    progress_bar_hero_exp.progress = hero.experiencePoint.toInt()

    GlideApp.with(this).load(hero.avatarUrl)
        .placeholder(R.drawable.ic_cricle_placeholder)
        .circleCrop()
        .into(iv_hero)
    tv_hero_name.text = hero.name
    tv_hero_lvl_exp.text = Phrase.from(context(), R.string.format_hero_lvl)
        .put("lvl", hero.level)
        .put("title", hero.rank)
        .format()
  }

  override fun onDestroy() {
    super.onDestroy()
    questPresenter.destroy()
    heroPresenter.destroy()
  }
}