package com.example.wanandroidkotlin.homes.paging

import com.example.wanandroidkotlin.base.BaseDataSourceFactory
import com.example.wanandroidkotlin.base.BasePagingRepository
import com.example.wanandroidkotlin.homes.model.DataX

/**
 *  Created by hannah on 2020-02-06
 */
class HomeRepository : BasePagingRepository<DataX>(){

    override fun createDataBaseFactory(): BaseDataSourceFactory<DataX> {
        return HomeDataSourceFactory()
    }

}
