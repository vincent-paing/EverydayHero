package me.aungkyawpaing.everydayhero.view.core

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import java.util.ArrayList
import javax.inject.Inject

/**
 * Created by vincentpaing on 8/28/17.
 */
class FragmentViewPagerAdapter constructor(fm: FragmentManager) : FragmentStatePagerAdapter(fm) {

  private val mFragmentList = ArrayList<Fragment>()
  private val mFragmentTitleList = ArrayList<String>()

  override fun getItem(position: Int): Fragment {
    return mFragmentList[position]
  }

  override fun getCount(): Int {
    return mFragmentList.size
  }

  fun addFrag(fragment: Fragment, title: String) {
    mFragmentList.add(fragment)
    mFragmentTitleList.add(title)
  }

  fun addFrag(fragment: Fragment) {
    addFrag(fragment, "")
  }

  fun clear() {
    mFragmentList.clear()
    mFragmentTitleList.clear()
  }

  override fun getPageTitle(position: Int): CharSequence {
    return if (position < mFragmentTitleList.size) {
      mFragmentTitleList[position]
    } else {
      ""
    }
  }
}