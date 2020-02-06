package com.example.wanandroidkotlin.base

import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource

/**
 *  Created by hannah on 2020-02-06
 *  数据源工厂
 *  它提供了一种观察上次创建的数据源的方式，这使得我们能够将其网络请求状态等返回到UI界面
 */
abstract class BaseDataSourceFactory<T>: DataSource.Factory<Int, T>(){

    val sourceLiveData = MutableLiveData<BaseItemKeyedDataSource<T>>()

    override fun create(): BaseItemKeyedDataSource<T> {
        val dataSource: BaseItemKeyedDataSource<T> = createDataSource()
        sourceLiveData.postValue(dataSource)
        return dataSource
    }

    abstract fun createDataSource(): BaseItemKeyedDataSource<T>
}
