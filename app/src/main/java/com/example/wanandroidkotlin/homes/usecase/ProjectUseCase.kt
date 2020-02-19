package com.example.wanandroidkotlin.homes.usecase

import com.example.wanandroidkotlin.homes.model.ProjectData
import com.example.wanandroidkotlin.homes.model.Tab
import io.reactivex.Observable

/**
 *  Created by hannah on 2020-01-29
 */
abstract class ProjectUseCase {
    abstract fun getTabs(): Observable<List<Tab>>

    abstract fun getProjects(cid: Int): Observable<List<ProjectData>>
}
