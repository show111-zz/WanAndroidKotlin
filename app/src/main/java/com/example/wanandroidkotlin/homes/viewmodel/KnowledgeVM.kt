package com.example.wanandroidkotlin.homes.viewmodel

import com.example.wanandroidkotlin.base.BaseViewModel
import com.example.wanandroidkotlin.homes.usecase.KnowledgeUseCaseImpl

/**
 *  Created by hannah on 2020-01-28
 */
class KnowledgeVM(knowledgeUseCaseImpl: KnowledgeUseCaseImpl) : BaseViewModel(){
    var knowledge = knowledgeUseCaseImpl.getKnowledgeList()
}
