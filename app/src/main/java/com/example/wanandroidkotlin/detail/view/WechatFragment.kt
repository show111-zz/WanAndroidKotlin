package com.example.wanandroidkotlin.detail.view

import com.example.wanandroidkotlin.R
import com.example.wanandroidkotlin.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_project.*
import kotlinx.android.synthetic.main.fragment_wechat.*

/**
 *  Created by hannah on 2020-01-28
 */
class WechatFragment : BaseFragment(){

    override var layoutId: Int = R.layout.fragment_wechat

    override fun initData() {
        name.text = "wechat page"
    }

}
