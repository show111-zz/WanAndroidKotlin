package com.example.wanandroidkotlin.http

import com.example.wanandroidkotlin.detail.model.*
import com.example.wanandroidkotlin.homes.model.Article
import com.example.wanandroidkotlin.homes.model.BannerBean
import com.example.wanandroidkotlin.homes.model.ArticleItem
import com.example.wanandroidkotlin.homes.model.ArticleList
import io.reactivex.Observable
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

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

    @GET("article/list/{page}/json")
    fun getArticleList2(@Path("page") id: Int): Single<Article>

    @GET("article/list/{page}/json")
    fun getArticleList3(@Path("page") page: Int): List<ArticleItem>

    // knowledge
    @GET("tree/json")
    fun getKnowledgesList(): Observable<Knowledge>

    // wechat
    @GET("wxarticle/list/408/{page}/json")
    fun getWechatList(@Path("page") id: Int): Observable<Wechat>


    @GET("project/tree/json")
    fun getTabList(): Observable<TabBean>


    @GET("project/list/1/json")
    fun getTabProjectList(@Query("cid")cid: Int): Observable<Project>


}
