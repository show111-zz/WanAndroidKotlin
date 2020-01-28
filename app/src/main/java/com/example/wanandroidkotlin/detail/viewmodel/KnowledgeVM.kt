package com.example.wanandroidkotlin.detail.viewmodel

import androidx.lifecycle.ViewModel
import com.example.wanandroidkotlin.detail.usecase.KnowledgeUseCaseImpl

/**
 *  Created by hannah on 2020-01-28
 */
class KnowledgeVM(knowledgeUseCaseImpl: KnowledgeUseCaseImpl) : ViewModel(){

    var knowledge = knowledgeUseCaseImpl.getKnowledgeList()

}
