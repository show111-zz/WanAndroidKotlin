package com.example.wanandroidkotlin.detail.usecase

import com.example.wanandroidkotlin.detail.model.ProjectData
import com.example.wanandroidkotlin.detail.model.Tab
import com.example.wanandroidkotlin.http.HttpManager
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 *  Created by hannah on 2020-01-29
 */
class ProjectUseCaseImpl : ProjectUseCase(){

    override fun getProjects(cid: Int): Observable<List<ProjectData>> {
        return HttpManager.getHttpManager().retrofit()
            .getTabProjectList(cid)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .map { it.data.datas }
    }

    override fun getTabs(): Observable<List<Tab>> {
        return HttpManager.getHttpManager().retrofit()
            .getTabList()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .map { it.data }
    }

}
