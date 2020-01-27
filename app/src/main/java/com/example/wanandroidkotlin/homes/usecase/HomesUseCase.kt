package com.example.wanandroidkotlin.homes.usecase

import com.example.wanandroidkotlin.homes.model.Article
import com.example.wanandroidkotlin.homes.model.BannerBean
import io.reactivex.Observable

/**
 *  Created by hannah on 2020-01-21
 */
interface HomesUseCase {
     fun getBanner(): Observable<BannerBean>

     fun getArticle(): Observable<Article>
}
