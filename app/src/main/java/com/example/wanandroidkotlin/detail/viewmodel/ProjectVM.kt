package com.example.wanandroidkotlin.detail.viewmodel

import androidx.lifecycle.ViewModel
import com.example.wanandroidkotlin.detail.usecase.ProjectUseCaseImpl

/**
 *  Created by hannah on 2020-01-29
 */
class ProjectVM(private val projectUseCase: ProjectUseCaseImpl): ViewModel(){

    val tabs = projectUseCase.getTabs()
}
