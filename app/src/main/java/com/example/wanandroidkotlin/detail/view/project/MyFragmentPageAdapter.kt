package com.example.wanandroidkotlin.detail.view.project

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.example.wanandroidkotlin.detail.viewmodel.TabViewModel

/**
 *  Created by hannah on 2020-01-29
 */
class MyFragmentPageAdapter(
    tabs: List<TabViewModel>,
    fragmentManager: FragmentManager
) : FragmentStatePagerAdapter(fragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    private var fragmentList = tabs.map {
        TabFragment(it)
    }.toMutableList()

//    private var fragmentList = setData(tabs)

    override fun getItem(position: Int): Fragment {
        return fragmentList[position]
    }

    override fun getCount(): Int = fragmentList.size

    override fun getPageTitle(position: Int): CharSequence? {
        return fragmentList[position].tabViewModel.tab.name
    }

//    fun setData(data: List<TabViewModel>) : MutableList<TabFragment>{
//        val fragmentList = mutableListOf<TabFragment>()
//        fragmentList.clear()
//        fragmentList.addAll(data.map { TabFragment(it) })
//        notifyDataSetChanged()
//        return fragmentList
//    }

}
