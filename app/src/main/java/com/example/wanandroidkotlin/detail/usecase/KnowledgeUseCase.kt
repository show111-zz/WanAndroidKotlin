package com.example.wanandroidkotlin.detail.usecase

import com.example.wanandroidkotlin.detail.model.Data
import io.reactivex.Observable

/**
 *  Created by hannah on 2020-01-28
 */
abstract class KnowledgeUseCase{
    abstract fun getKnowledgeList(): Observable<List<Data>>
}
