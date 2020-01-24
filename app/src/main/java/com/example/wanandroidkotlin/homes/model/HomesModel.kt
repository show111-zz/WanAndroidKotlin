package com.example.wanandroidkotlin.homes.model

import com.example.wanandroidkotlin.data.Article
import com.example.wanandroidkotlin.data.BannerBean
import io.reactivex.Observable

/**
 *  Created by hannah on 2020-01-21
 */
interface HomesModel {
     fun getBanner(): Observable<BannerBean>

     fun getArticle(): Observable<Article>
}
