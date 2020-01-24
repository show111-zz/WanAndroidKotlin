package com.example.wanandroidkotlin.http

import com.example.wanandroidkotlin.data.Article
import com.example.wanandroidkotlin.data.BannerBean
import io.reactivex.Observable
import retrofit2.http.GET

/**
 *  Created by hannah on 2020-01-17
 */
interface ApiServices{

    companion object{
        const val API_BASE_URL = "https://www.wanandroid.com"
    }

    // banner
    @GET("banner/json")
    fun getTop250(): Observable<BannerBean>


    // article list
    @GET("article/list/0/json")
    fun getArticleList(): Observable<Article>


}