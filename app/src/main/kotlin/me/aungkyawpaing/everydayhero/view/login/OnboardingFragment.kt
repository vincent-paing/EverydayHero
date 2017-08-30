package me.aungkyawpaing.everydayhero.view.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_onboarding.iv_onboarding_image
import kotlinx.android.synthetic.main.fragment_onboarding.tv_onboarding_description
import kotlinx.android.synthetic.main.fragment_onboarding.tv_onboarding_title
import me.aungkyawpaing.everydayhero.GlideApp
import me.aungkyawpaing.everydayhero.R
import me.aungkyawpaing.everydayhero.view.core.BaseFragment

/**
 * Created by vincentpaing on 8/27/17.
 */
class OnboardingFragment : BaseFragment() {

  var imageResId: Int = 0
  var titleResId: Int = 0
  var descriptionResId: Int = 0

  companion object {

    const val KEY_IMAGE = "IMAGE"
    const val KEY_TITLE = "TITLE"
    const val KEY_DESC = "DESC"

    const val FRAGMENT_ONE = 1
    const val FRAGMENT_TWO = 2
    const val FRAGMENT_THREE = 3


    fun newInstance(fragmentNo: Int): OnboardingFragment {
      val onbarodingFragment = OnboardingFragment()

      var imageResId: Int? = null
      var titleResId: Int? = null
      var descriptionResId: Int? = null

      when (fragmentNo) {
        FRAGMENT_ONE -> {
          imageResId = R.drawable.screen1
          titleResId = R.string.onboarding_title_one
          descriptionResId = R.string.onboarding_description_one
        }
        FRAGMENT_TWO -> {
          imageResId = R.drawable.screen2
          titleResId = R.string.onboarding_title_two
          descriptionResId = R.string.onboarding_description_two
        }
        else -> {
          imageResId = R.drawable.screen3
          titleResId = R.string.onboarding_title_three
          descriptionResId = R.string.onboarding_description_three
        }
      }

      val args = Bundle()
      args.putInt(KEY_IMAGE, imageResId)
      args.putInt(KEY_TITLE, titleResId)
      args.putInt(KEY_DESC, descriptionResId)
      onbarodingFragment.arguments = args

      return onbarodingFragment
    }
  }

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    imageResId = arguments.getInt(
        KEY_IMAGE)
    titleResId = arguments.getInt(
        KEY_TITLE)
    descriptionResId = arguments.getInt(
        KEY_DESC)

  }

  override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
      savedInstanceState: Bundle?): View? {

    val rootView = inflater?.inflate(R.layout.fragment_onboarding, container, false)
    return rootView
  }

  override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    setupLayout()
  }

  private fun setupLayout() {
    GlideApp.with(this)
        .load(imageResId)
        .into(iv_onboarding_image)
    tv_onboarding_title.setText(titleResId)
    tv_onboarding_description.setText(descriptionResId)
  }

}
