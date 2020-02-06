package com.example.wanandroidkotlin.base

import androidx.lifecycle.MutableLiveData
import androidx.paging.ItemKeyedDataSource
import com.example.wanandroidkotlin.utils.ExecutorUtils

/**
 *  Created by hannah on 2020-02-06
 */
abstract class BaseItemKeyedDataSource<T>: ItemKeyedDataSource<Int, T>(){

    private var retry: (()->Any)? = null

    private var retryExecutor = ExecutorUtils.NETWORK_IO

    val refreshState by lazy {
        MutableLiveData<RequestState<Boolean>>()
    }

    val loadMoreState by lazy {
        MutableLiveData<RequestState<Boolean>>()
    }

    fun retryFailed(){
        val preRetry = retry
        retry = null
        preRetry.let { retryExecutor.execute { it?.invoke() } }
    }

    /** 接收初始加载的数据，在这里需要将获取到的数据通过LoadInitialCallback的onResult进行回调， 用于初始化pagelist, 并对加载的项目进行计数 */
    override fun loadInitial(params: LoadInitialParams<Int>, callback: LoadInitialCallback<T>) {
        refreshState.postValue(RequestState.loading())
        onLoadInitial(params, callback)
    }

    /** 接收加载的数据 */
    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<T>) {
        loadMoreState.postValue(RequestState.loading())
        onLoadAfter(params, callback)
    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<T>) {
    }

    override fun getKey(item: T): Int = setKey(item)


    abstract fun setKey(item: T): Int
    abstract fun onLoadInitial(params: LoadInitialParams<Int>, callback: LoadInitialCallback<T>)
    abstract fun onLoadAfter(params: LoadParams<Int>, callback: LoadCallback<T>)

}
