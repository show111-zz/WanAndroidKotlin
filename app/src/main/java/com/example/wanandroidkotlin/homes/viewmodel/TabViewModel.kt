package com.example.wanandroidkotlin.homes.viewmodel

import com.example.wanandroidkotlin.base.BaseViewModel
import com.example.wanandroidkotlin.homes.model.ProjectData
import com.example.wanandroidkotlin.homes.model.Tab
import com.example.wanandroidkotlin.homes.usecase.ProjectUseCase
import io.reactivex.Observable

/**
 *  Created by hannah on 2020-01-31
 */
class TabViewModel(val tab: Tab, private val projectsUseCase: ProjectUseCase) : BaseViewModel(){
    val projectData: Observable<List<ProjectData>> = projectsUseCase.getProjects(tab.id)
}
