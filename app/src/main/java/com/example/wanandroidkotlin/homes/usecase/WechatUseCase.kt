package com.example.wanandroidkotlin.homes.usecase

import com.example.wanandroidkotlin.homes.model.WechatX
import io.reactivex.Observable

/**
 *  Created by hannah on 2020-01-29
 */
abstract class WechatUseCase {
    abstract fun getWechatList(page: Int): Observable<List<WechatX>>
}
