package com.example.wanandroidkotlin.base

import androidx.lifecycle.Transformations
import androidx.paging.Config
import androidx.paging.toLiveData

/**
 *  Created by hannah on 2020-02-06
 *  Repository实现返回一个直接从网络加载数据的Listing，并作为加载上一页/下一页数据的关键
 */
abstract class BasePagingRepository<T> {

    abstract fun createDataBaseFactory(): BaseDataSourceFactory<T>

    fun getData(page: Int):Listing<T>{

        val sourceFactory = createDataBaseFactory()

        // 设置Executor执行器用于从用于从DataSources中获取PagedLists数据，如果未设置，则默认为Arch组件I/O线程。
        val pageList = sourceFactory.toLiveData(
            config = Config(pageSize = page, enablePlaceholders = false, initialLoadSizeHint = page * 2)
        )

        val refreshState = Transformations.switchMap(sourceFactory.sourceLiveData){
            it.refreshState
        }

        val loadMoreState = Transformations.switchMap(sourceFactory.sourceLiveData){
            it.loadMoreState
        }

        return Listing(pagedList= pageList, networkState =loadMoreState, refreshState = refreshState, refresh = {sourceFactory.sourceLiveData.value?.invalidate()}, retry = {sourceFactory.sourceLiveData.value?.retryFailed()} )
    }


}
