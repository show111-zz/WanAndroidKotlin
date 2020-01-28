package com.example.wanandroidkotlin.http

import com.example.wanandroidkotlin.detail.model.Knowledge
import com.example.wanandroidkotlin.homes.model.Article
import com.example.wanandroidkotlin.homes.model.BannerBean
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

    // knowledge
    @GET("tree/json")
    fun getKnowledgesList(): Observable<Knowledge>


}
