package com.example.wanandroidkotlin.detail.view.project

import androidx.fragment.app.Fragment
import com.example.wanandroidkotlin.R
import com.example.wanandroidkotlin.base.BaseFragment
import com.example.wanandroidkotlin.detail.model.Tab
import com.example.wanandroidkotlin.detail.usecase.ProjectUseCaseImpl
import com.example.wanandroidkotlin.detail.viewmodel.ProjectVM
import io.reactivex.rxkotlin.subscribeBy
import kotlinx.android.synthetic.main.fragment_project.*

/**
 *  Created by hannah on 2020-01-28
 */
class ProjectFragment : BaseFragment(){

    private val tabs: MutableList<Tab> = arrayListOf()

    private var list : MutableList<Fragment> = arrayListOf()

    private var projectVM = ProjectVM(ProjectUseCaseImpl())

    lateinit var pageAdapter: MyFragmentPageAdapter

    override var layoutId: Int = R.layout.fragment_project

    override fun initData() {
        loadTabs()
    }

    private fun loadTabs() {
        projectVM.tabs.subscribeBy {
            it.forEach {
                tabs.add(it)
                list.add(TabFragment(it,projectVM))
            }
            initTab()
        }
    }

    private fun initTab() {
        pageAdapter = MyFragmentPageAdapter(tabs, requireFragmentManager(), list)
        viewPager.adapter = pageAdapter
        tabLayout.setupWithViewPager(viewPager)
    }

}
