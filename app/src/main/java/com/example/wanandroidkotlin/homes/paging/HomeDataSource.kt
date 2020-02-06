package com.example.wanandroidkotlin.homes.paging

import com.example.wanandroidkotlin.base.BaseItemKeyedDataSource
import com.example.wanandroidkotlin.homes.model.DataX

/**
 *  Created by hannah on 2020-02-06
 */
class HomeDataSource: BaseItemKeyedDataSource<DataX>(){

    var pageNum = 0

    override fun setKey(item: DataX): Int = item.id


    override fun onLoadInitial(params: LoadInitialParams<Int>, callback: LoadInitialCallback<DataX>) {

    }

    override fun onLoadAfter(params: LoadParams<Int>, callback: LoadCallback<DataX>) {

    }

}
