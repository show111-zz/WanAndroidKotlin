package com.example.wanandroidkotlin.homes.viewmodel

import androidx.lifecycle.LiveData
import androidx.paging.PagedList
import com.example.wanandroidkotlin.base.BaseViewModel
import com.example.wanandroidkotlin.homes.model.ArticleItem
import com.example.wanandroidkotlin.homes.paging.HomeRepository

/**
 *  Created by hannah on 2020-02-07
 */
class HomeViewModel(private val homeRepository: HomeRepository): BaseViewModel(){

    val articleList: LiveData<PagedList<ArticleItem>> by lazy {
        homeRepository.getHomeData(compositeDisposable)
    }

}
