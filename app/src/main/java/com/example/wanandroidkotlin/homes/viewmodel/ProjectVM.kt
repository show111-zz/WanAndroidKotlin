package com.example.wanandroidkotlin.homes.viewmodel

import com.example.wanandroidkotlin.base.BaseViewModel
import com.example.wanandroidkotlin.homes.model.Tab
import com.example.wanandroidkotlin.homes.usecase.ProjectUseCase

/**
 *  Created by hannah on 2020-01-29
 */
class ProjectVM(private val projectUseCase: ProjectUseCase) : BaseViewModel() {

    val tabs = projectUseCase
        .getTabs()
        .map {
            it.map{ tab: Tab ->
                TabViewModel(
                    tab,
                    projectUseCase
                )
            }
        }
}

