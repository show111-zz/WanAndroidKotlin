package com.example.wanandroidkotlin.detail.view.project

import com.example.wanandroidkotlin.R
import com.example.wanandroidkotlin.base.BaseFragment
import com.example.wanandroidkotlin.detail.viewmodel.TabViewModel
import io.reactivex.rxkotlin.subscribeBy
import kotlinx.android.synthetic.main.fragment_tab_project.*

/**
 *  Created by hannah on 2020-01-29
 */
class TabFragment(val tabViewModel: TabViewModel) : BaseFragment() {

    override var layoutId: Int = R.layout.fragment_tab_project

    override fun initData() {

        tabViewModel.projectData.subscribeBy(
            onNext = { author.text = it.get(0).title },
//            onError ={ error -> Log.e("hui",  error.message ?: "No Error")}
            onError ={ error -> error.printStackTrace() }
        ).disposeOnClear()

    }


}
