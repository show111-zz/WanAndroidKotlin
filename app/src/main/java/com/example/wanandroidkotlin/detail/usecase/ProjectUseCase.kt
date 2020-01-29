package com.example.wanandroidkotlin.detail.usecase

import com.example.wanandroidkotlin.detail.model.ProjectData
import com.example.wanandroidkotlin.detail.model.Tab
import io.reactivex.Observable

/**
 *  Created by hannah on 2020-01-29
 */
abstract class ProjectUseCase {
    abstract fun getTabs(): Observable<List<Tab>>

    abstract fun getProjects(cid: Int): Observable<List<ProjectData>>
}
