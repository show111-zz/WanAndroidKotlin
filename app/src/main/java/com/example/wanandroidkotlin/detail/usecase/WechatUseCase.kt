package com.example.wanandroidkotlin.detail.usecase

import com.example.wanandroidkotlin.detail.model.WechatX
import io.reactivex.Observable

/**
 *  Created by hannah on 2020-01-29
 */
abstract class WechatUseCase {
    abstract fun getWechatList(page: Int): Observable<List<WechatX>>
}
