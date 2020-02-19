package com.example.wanandroidkotlin.homes.paging

import android.util.Log
import androidx.paging.PageKeyedDataSource
import com.example.wanandroidkotlin.homes.model.ArticleItem
import com.example.wanandroidkotlin.http.RestApiFactory
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers

/**
 *  Created by hannah on 2020-02-06
 */
class HomeDataSource(private val compositeDisposable: CompositeDisposable) :
    PageKeyedDataSource<Int, ArticleItem>() {

    private var pageNum = 0

    override fun loadInitial(
        params: LoadInitialParams<Int>,
        callback: LoadInitialCallback<Int, ArticleItem>
    ) {
        compositeDisposable.add(
            RestApiFactory.getHttpManager().retrofit().getArticleList2(pageNum)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeBy(
                    onSuccess = {
                        callback.onResult(it.data.datas, null, pageNum + 1)
                    },
                    onError = {
                       Log.d("hui",  it.message!!)
                    }
                )
        )
    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, ArticleItem>) {
        Log.d("hui",  "params key is ${params.key}")
        compositeDisposable.add(
            RestApiFactory.getHttpManager().retrofit().getArticleList2(params.key)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeBy(
                    onSuccess = {
                        if (it.data.pageCount >= params.key) {
                            callback.onResult(it.data.datas, params.key + 1)
                        }
                    },
                    onError = {
                        Log.d("hui",  it.message!!)
                    }
                )
        )
    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, ArticleItem>) {

    }


}
