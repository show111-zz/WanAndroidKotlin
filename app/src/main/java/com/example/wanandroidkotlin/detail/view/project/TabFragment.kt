package com.example.wanandroidkotlin.detail.view.project

import androidx.recyclerview.widget.LinearLayoutManager
import com.example.wanandroidkotlin.R
import com.example.wanandroidkotlin.base.BaseFragment
import com.example.wanandroidkotlin.detail.model.ProjectData
import com.example.wanandroidkotlin.detail.viewmodel.TabViewModel
import io.reactivex.rxkotlin.subscribeBy
import kotlinx.android.synthetic.main.fragment_tab_project.*

/**
 *  Created by hannah on 2020-01-29
 */
class TabFragment(val tabViewModel: TabViewModel) : BaseFragment() {

    private lateinit var tabAdapter : TabListAdapter

    override var layoutId: Int = R.layout.fragment_tab_project

    override fun initData() {
        tabAdapter = TabListAdapter()

        wechatRecyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = tabAdapter
        }

        tabViewModel.projectData.subscribeBy(
            onNext = { loadTabListData(it) },
            onError = { error -> error.printStackTrace() }
        ).disposeOnClear()
    }

    private fun loadTabListData(tabArticles: List<ProjectData>) {
        tabAdapter.setTabData(tabArticles)
        tabAdapter.notifyDataSetChanged()
    }


}
