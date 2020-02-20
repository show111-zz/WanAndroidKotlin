package com.example.wanandroidkotlin.homes.paging

import android.util.Log
import androidx.paging.PageKeyedDataSource
import com.example.wanandroidkotlin.homes.model.*
import com.example.wanandroidkotlin.http.RestApiFactory
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.functions.BiFunction
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers
import com.example.wanandroidkotlin.homes.paging.HomeDataSource


/**
 *  Created by hannah on 2020-02-06
 */
class HomeDataSource(private val compositeDisposable: CompositeDisposable) :
    PageKeyedDataSource<Int, ArticleItem>() {

    private var pageNum = 0

    private val apiRequest = RestApiFactory.getHttpManager().retrofit()

    override fun loadInitial(params: LoadInitialParams<Int>, callback: LoadInitialCallback<Int, ArticleItem>) {
       compositeDisposable.add(
           Single.zip(apiRequest.getTop250(), apiRequest.getArticleList(pageNum), BiFunction<BannerBean, Article, ArticleList> { t1, t2 ->
               t1.data.let {
                   val article = t2.data.datas
                   article[0].bannerData = it
                   t2.data
               }
               t2.data
           }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
               .subscribeBy(
                   onSuccess = {
                       callback.onResult(it.datas, null, pageNum + 1)
                   },
                   onError = {
                       Log.d("hui", it.message!!)
                   }
               )
       )
    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, ArticleItem>) {
        Log.d("hui", "params key is ${params.key}")
        compositeDisposable.add(
            apiRequest.getArticleList(params.key)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeBy(
                    onSuccess = {
                        if (it.data.pageCount >= params.key) {
                            callback.onResult(it.data.datas, params.key + 1)
                        }
                    },
                    onError = {
                        Log.d("hui", it.message!!)
                    }
                )
        )
    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, ArticleItem>) {

    }


}
