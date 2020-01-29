package com.example.wanandroidkotlin.detail.viewmodel

import androidx.lifecycle.ViewModel
import com.example.wanandroidkotlin.detail.usecase.WechatUseCaseImpl

/**
 *  Created by hannah on 2020-01-29
 */
class WechatVM(wechatUseCaseImpl: WechatUseCaseImpl): ViewModel(){
    val wechats = wechatUseCaseImpl.getWechatList()
}
