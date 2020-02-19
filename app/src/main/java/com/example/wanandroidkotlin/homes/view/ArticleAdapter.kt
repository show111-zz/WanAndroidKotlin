package com.example.wanandroidkotlin.homes.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.wanandroidkotlin.R
import com.example.wanandroidkotlin.homes.model.ArticleItem

/**
 *  Created by hannah on 2020-01-24
 */
class ArticleAdapter : RecyclerView.Adapter<ArticleHolder>() {

    private var articles = listOf<ArticleItem>()
    var onItemClick: ((ArticleItem) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleHolder {
        var articleView =
            LayoutInflater.from(parent.context).inflate(R.layout.view_item_article, parent, false)
        return ArticleHolder(articleView)
    }

    override fun getItemCount(): Int = articles.size

    override fun onBindViewHolder(holder: ArticleHolder, position: Int) {
        holder.showArticle(articles[position], onItemClick)
    }

    fun updateList(articles: List<ArticleItem>) {
        this.articles = articles
    }

}
