package com.example.wanandroidkotlin.detail.viewmodel

import com.example.wanandroidkotlin.base.BaseViewModel
import com.example.wanandroidkotlin.detail.model.ProjectData
import com.example.wanandroidkotlin.detail.model.Tab
import com.example.wanandroidkotlin.detail.usecase.ProjectUseCase
import io.reactivex.Observable

/**
 *  Created by hannah on 2020-01-31
 */
class TabViewModel(val tab: Tab, private val projectsUseCase: ProjectUseCase) : BaseViewModel(){
    val projectData: Observable<List<ProjectData>> = projectsUseCase.getProjects(tab.id)
}
