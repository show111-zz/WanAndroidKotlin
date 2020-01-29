package com.example.wanandroidkotlin.detail.view.project

import com.example.wanandroidkotlin.R
import com.example.wanandroidkotlin.base.BaseFragment
import com.example.wanandroidkotlin.detail.model.Tab
import com.example.wanandroidkotlin.detail.viewmodel.ProjectVM
import kotlinx.android.synthetic.main.fragment_tab_project.*

/**
 *  Created by hannah on 2020-01-29
 */
class TabFragment(private var tab: Tab, private var projectVM: ProjectVM) : BaseFragment() {

    override var layoutId: Int = R.layout.fragment_tab_project

    override fun initData() {
        author.text = tab.name
//        loadProjectArticle(tab.id)
    }



}
