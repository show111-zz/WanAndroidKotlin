package com.example.wanandroidkotlin.homes.paging

import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import com.example.wanandroidkotlin.homes.model.ArticleItem
import io.reactivex.disposables.CompositeDisposable

/**
 *  Created by hannah on 2020-02-06
 */
class HomeDataSourceFactory(private val compositeDisposable: CompositeDisposable) : DataSource.Factory<Int, ArticleItem>() {

    private val homeLiveDataSource = MutableLiveData<HomeDataSource>()

    override fun create(): DataSource<Int, ArticleItem> {
        val homeDataSource = HomeDataSource(compositeDisposable)
        homeLiveDataSource.postValue(homeDataSource)
        return homeDataSource
    }


}
