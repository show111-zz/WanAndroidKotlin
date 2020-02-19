package com.example.wanandroidkotlin.homes.view.project

import com.example.wanandroidkotlin.R
import com.example.wanandroidkotlin.base.BaseFragment
import com.example.wanandroidkotlin.homes.usecase.ProjectUseCaseImpl
import com.example.wanandroidkotlin.homes.viewmodel.ProjectVM
import io.reactivex.rxkotlin.subscribeBy
import kotlinx.android.synthetic.main.fragment_project.*

/**
 *  Created by hannah on 2020-01-28
 */
class ProjectFragment : BaseFragment(){

    private var projectVM =
        ProjectVM(ProjectUseCaseImpl())

    lateinit var pageAdapter: MyFragmentPageAdapter

    override var layoutId: Int = R.layout.fragment_project

    override fun initData() {
        loadTabs()
    }

    private fun loadTabs() {
        projectVM.tabs.subscribeBy {
            pageAdapter = MyFragmentPageAdapter(it, childFragmentManager)
            viewPager.adapter = pageAdapter
            tabLayout.setupWithViewPager(viewPager)
        }.disposeOnClear()

    }

}
