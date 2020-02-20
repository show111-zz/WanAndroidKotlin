package com.example.wanandroidkotlin.homes.view.home

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.wanandroidkotlin.homes.model.ArticleItem
import com.example.wanandroidkotlin.homes.model.ArticleList
import com.example.wanandroidkotlin.homes.model.Banner
import io.reactivex.Single
import kotlinx.android.synthetic.main.view_header_home.view.*

/**
 *  Created by hannah on 2020-02-19
 */
class ArticleHeaderHolder(header: View): RecyclerView.ViewHolder(header){

    private val header: View = header

    fun bindHeader2(article: ArticleItem){

        if(article.bannerData.isNotEmpty()){
            Glide.with(header)
                .load(article.bannerData[0].imagePath)
                .into(header.poster)
        }

    }

}
