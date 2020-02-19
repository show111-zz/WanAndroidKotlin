package com.example.wanandroidkotlin.homes.viewmodel

import com.example.wanandroidkotlin.base.BaseViewModel
import com.example.wanandroidkotlin.homes.usecase.WechatUseCaseImpl

/**
 *  Created by hannah on 2020-01-29
 */
class WechatVM(wechatUseCaseImpl: WechatUseCaseImpl, page: Int): BaseViewModel(){

    val wechats = wechatUseCaseImpl.getWechatList(page)

}
