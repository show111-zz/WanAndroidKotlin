package com.example.wanandroidkotlin.homes.viewmodel

import com.example.wanandroidkotlin.base.BaseViewModel
import com.example.wanandroidkotlin.homes.model.Article
import com.example.wanandroidkotlin.homes.model.BannerBean
import com.example.wanandroidkotlin.homes.paging.HomeRepository
import com.example.wanandroidkotlin.homes.usecase.HomesUseCaseImpl
import io.reactivex.Observable

/**
 *  Created by hannah on 2020-01-21
 */
class HomeVM(homeUseCase: HomesUseCaseImpl): BaseViewModel() {

    val homeRepository: HomeRepository= HomeRepository()

    val homes: Observable<BannerBean> = homeUseCase.getBanner()

    val articles: Observable<Article> = homeUseCase.getArticle()

}
