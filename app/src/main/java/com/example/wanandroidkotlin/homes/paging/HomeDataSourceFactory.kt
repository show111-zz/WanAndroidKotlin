package com.example.wanandroidkotlin.homes.paging

import com.example.wanandroidkotlin.base.BaseDataSourceFactory
import com.example.wanandroidkotlin.base.BaseItemKeyedDataSource
import com.example.wanandroidkotlin.homes.model.DataX

/**
 *  Created by hannah on 2020-02-06
 */
class HomeDataSourceFactory : BaseDataSourceFactory<DataX>(){

    override fun createDataSource(): BaseItemKeyedDataSource<DataX> {
        return HomeDataSource()
    }

}
