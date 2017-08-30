package me.aungkyawpaing.everydayhero.view.avatars

import android.app.Activity
import android.content.Context
import android.os.Bundle
import me.aungkyawpaing.everydayhero.R
import me.aungkyawpaing.everydayhero.view.core.BaseActivity
import android.content.Intent


/**
 * Created by vincentpaing on 8/28/17.
 */
class AvatarActivity : BaseActivity() {

  companion object {
    const val KEY_SAVE = "KEY_SAVE"
//
//    fun start(activity: BaseActivity) {
//      activity.startActivityForResult()
//    }
  }

  override val layoutResId: Int
    get() = R.layout.activity_avatar

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    val avatarFragment = AvatarFragment.newInstance()
    setToolbarTitle("Select Avatar")
    supportActionBar?.setDisplayHomeAsUpEnabled(true)

    avatarFragment.onSave = {
      val intent = Intent()
      intent.putExtra(KEY_SAVE, true)
      setResult(Activity.RESULT_OK, intent)
      finish()
    }
    replaceFragment(R.id.container, avatarFragment)
  }

}