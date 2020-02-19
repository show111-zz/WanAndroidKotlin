package com.example.wanandroidkotlin.homes.paging

import androidx.lifecycle.LiveData
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.example.wanandroidkotlin.homes.model.ArticleItem
import io.reactivex.disposables.CompositeDisposable

/**
 *  Created by hannah on 2020-02-06
 */
class HomeRepository{

    lateinit var homePageList: LiveData<PagedList<ArticleItem>>
    lateinit var homeDataSourceFactory: HomeDataSourceFactory

    fun getHomeData(compositeDisposable: CompositeDisposable): LiveData<PagedList<ArticleItem>> {

        homeDataSourceFactory = HomeDataSourceFactory(compositeDisposable)

        val config = PagedList.Config.Builder().setEnablePlaceholders(false).setPageSize(20).setInitialLoadSizeHint(20).build()

        homePageList = LivePagedListBuilder(homeDataSourceFactory,config).build()

        return homePageList

    }

}
