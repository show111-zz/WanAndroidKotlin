package com.example.wanandroidkotlin.homes.usecase

import com.example.wanandroidkotlin.homes.model.Article
import com.example.wanandroidkotlin.homes.model.BannerBean
import com.example.wanandroidkotlin.http.RestApiFactory
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 *  Created by hannah on 2020-01-21
 */
class HomesUseCaseImpl : HomesUseCase {

    override fun getArticle(): Observable<Article> {
        return RestApiFactory.getHttpManager()
            .retrofit()
            .getArticleList()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }

    override fun getBanner(): Observable<BannerBean> {
        return RestApiFactory.getHttpManager()
            .retrofit()
            .getTop250()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }

}
