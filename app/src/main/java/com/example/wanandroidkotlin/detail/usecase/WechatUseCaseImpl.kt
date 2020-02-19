package com.example.wanandroidkotlin.detail.usecase

import com.example.wanandroidkotlin.detail.model.WechatX
import com.example.wanandroidkotlin.http.RestApiFactory
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 *  Created by hannah on 2020-01-29
 */
class WechatUseCaseImpl : WechatUseCase(){
    override fun getWechatList(page: Int): Observable<List<WechatX>> {
         return RestApiFactory.getHttpManager().retrofit()
             .getWechatList(page)
             .subscribeOn(Schedulers.io())
             .observeOn(AndroidSchedulers.mainThread())
             .map { it.data.datas }
    }

}
