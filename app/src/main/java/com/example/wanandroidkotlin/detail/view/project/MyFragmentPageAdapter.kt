package com.example.wanandroidkotlin.detail.view.project

import android.util.Log
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.wanandroidkotlin.detail.model.Tab

/**
 *  Created by hannah on 2020-01-29
 */
class MyFragmentPageAdapter(
    val tabs: List<Tab>,
    fragmentManager: FragmentManager,
    private var fragmentList: List<Fragment>
) : FragmentPagerAdapter(fragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    override fun getItem(position: Int): Fragment {
        return fragmentList[position]
    }

    override fun getCount(): Int = fragmentList.size

    override fun getPageTitle(position: Int): CharSequence? {
        Log.d("hui", tabs[position].name)
        return tabs[position].name
    }

}
