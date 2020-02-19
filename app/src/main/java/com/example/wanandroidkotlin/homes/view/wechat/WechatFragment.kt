package com.example.wanandroidkotlin.homes.view.wechat

import androidx.recyclerview.widget.LinearLayoutManager
import com.example.wanandroidkotlin.R
import com.example.wanandroidkotlin.base.BaseFragment
import com.example.wanandroidkotlin.homes.usecase.WechatUseCaseImpl
import com.example.wanandroidkotlin.homes.viewmodel.WechatVM
import io.reactivex.rxkotlin.subscribeBy
import kotlinx.android.synthetic.main.fragment_wechat.*

/**
 *  Created by hannah on 2020-01-28
 */
class WechatFragment : BaseFragment(){

    var page: Int = 1

    private lateinit var wechatAdapter: WechatAdapter

    private lateinit var wechatVM: WechatVM

    override var layoutId: Int = R.layout.fragment_wechat

    override fun initData() {
        wechatAdapter = WechatAdapter()

        wechatVM = WechatVM(WechatUseCaseImpl(), page)

        wechatRecyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = wechatAdapter
        }
        getMoreItems()
    }

    private fun getMoreItems() {
        wechatVM.wechats.subscribeBy {
            page++
            wechatAdapter.addData(ArrayList(it))
        }
    }

}
