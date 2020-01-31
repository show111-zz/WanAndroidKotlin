package com.example.wanandroidkotlin.detail.viewmodel

import com.example.wanandroidkotlin.base.BaseViewModel
import com.example.wanandroidkotlin.detail.model.ProjectData
import com.example.wanandroidkotlin.detail.model.Tab
import com.example.wanandroidkotlin.detail.usecase.ProjectUseCase
import io.reactivex.Observable

/**
 *  Created by hannah on 2020-01-29
 */
class ProjectVM(private val projectUseCase: ProjectUseCase) : BaseViewModel() {

    val tabs = projectUseCase
        .getTabs()
        .map {
            it.map{ tab: Tab -> TabViewModel(tab, projectUseCase) }
        }
}

