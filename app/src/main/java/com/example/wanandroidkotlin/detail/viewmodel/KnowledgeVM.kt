package com.example.wanandroidkotlin.detail.viewmodel

import com.example.wanandroidkotlin.base.BaseViewModel
import com.example.wanandroidkotlin.detail.usecase.KnowledgeUseCaseImpl

/**
 *  Created by hannah on 2020-01-28
 */
class KnowledgeVM(knowledgeUseCaseImpl: KnowledgeUseCaseImpl) : BaseViewModel(){
    var knowledge = knowledgeUseCaseImpl.getKnowledgeList()
}
