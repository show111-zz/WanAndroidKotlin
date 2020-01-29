package com.example.wanandroidkotlin.detail.view.wechat

import androidx.recyclerview.widget.LinearLayoutManager
import com.example.wanandroidkotlin.R
import com.example.wanandroidkotlin.base.BaseFragment
import com.example.wanandroidkotlin.detail.usecase.WechatUseCaseImpl
import com.example.wanandroidkotlin.detail.viewmodel.WechatVM
import io.reactivex.rxkotlin.subscribeBy
import kotlinx.android.synthetic.main.fragment_wechat.*

/**
 *  Created by hannah on 2020-01-28
 */
class WechatFragment : BaseFragment(){

    private lateinit var wechatAdapter: WechatAdapter

    private var wechatVM: WechatVM = WechatVM(WechatUseCaseImpl())

    override var layoutId: Int = R.layout.fragment_wechat

    override fun initData() {
        wechatAdapter = WechatAdapter()

        wechatRecyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = wechatAdapter
        }

        wechatVM.wechats.subscribeBy {
            wechatAdapter.setData(it)
            wechatAdapter.notifyDataSetChanged()
        }
    }

}
