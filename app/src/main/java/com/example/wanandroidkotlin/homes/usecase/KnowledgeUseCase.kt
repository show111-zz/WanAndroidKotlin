package com.example.wanandroidkotlin.homes.usecase

import com.example.wanandroidkotlin.homes.model.Data
import io.reactivex.Observable

/**
 *  Created by hannah on 2020-01-28
 */
abstract class KnowledgeUseCase{
    abstract fun getKnowledgeList(): Observable<List<Data>>
}
