package com.example.wanandroidkotlin.homes.model

import com.example.wanandroidkotlin.data.Article
import com.example.wanandroidkotlin.data.BannerBean
import com.example.wanandroidkotlin.http.HttpManager
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 *  Created by hannah on 2020-01-21
 */
class HomesModelImpl : HomesModel {


    override fun getArticle(): Observable<Article> {
        return HttpManager.getHttpManager()
            .retrofit()
            .getArticleList()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }


    override fun getBanner(): Observable<BannerBean> {
        return HttpManager.getHttpManager()
            .retrofit()
            .getTop250()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }

}
