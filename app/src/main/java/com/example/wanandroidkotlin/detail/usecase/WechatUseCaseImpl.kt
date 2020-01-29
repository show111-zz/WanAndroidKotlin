package com.example.wanandroidkotlin.detail.usecase

import com.example.wanandroidkotlin.detail.model.WechatX
import com.example.wanandroidkotlin.http.HttpManager
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 *  Created by hannah on 2020-01-29
 */
class WechatUseCaseImpl : WechatUseCase(){
    override fun getWechatList(): Observable<List<WechatX>> {
         return HttpManager.getHttpManager().retrofit()
             .getWechatList()
             .subscribeOn(Schedulers.io())
             .observeOn(AndroidSchedulers.mainThread())
             .map { it.data.datas }
    }

}
