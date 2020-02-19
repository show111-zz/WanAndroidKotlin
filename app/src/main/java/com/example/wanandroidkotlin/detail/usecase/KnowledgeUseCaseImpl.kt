package com.example.wanandroidkotlin.detail.usecase

import com.example.wanandroidkotlin.detail.model.Data
import com.example.wanandroidkotlin.http.RestApiFactory
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 *  Created by hannah on 2020-01-28
 */
class KnowledgeUseCaseImpl : KnowledgeUseCase(){
    override fun getKnowledgeList(): Observable<List<Data>> {
        return RestApiFactory.getHttpManager().retrofit()
            .getKnowledgesList()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .map { it.data }
    }

}
