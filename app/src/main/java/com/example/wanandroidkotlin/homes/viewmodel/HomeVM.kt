package com.example.wanandroidkotlin.homes.viewmodel

import com.example.wanandroidkotlin.base.BaseViewModel
import com.example.wanandroidkotlin.data.Article
import com.example.wanandroidkotlin.data.BannerBean
import com.example.wanandroidkotlin.homes.model.HomesModel
import io.reactivex.Observable

/**
 *  Created by hannah on 2020-01-21
 */
class HomeVM(homeModel: HomesModel): BaseViewModel() {

    val homes: Observable<BannerBean> = homeModel.getBanner()

    val articles: Observable<Article> = homeModel.getArticle()


}
