package com.example.wanandroidkotlin.homes.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import com.example.wanandroidkotlin.R
import com.example.wanandroidkotlin.homes.model.ArticleItem

/**
 *  Created by hannah on 2020-02-07
 */
class HomeAdapter3: PagedListAdapter<ArticleItem, ArticleHolder>(DIFF_CALLBACK) {

    var onItemClick: ((ArticleItem) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.view_item_article, parent, false)
        return ArticleHolder(view)
    }

    override fun onBindViewHolder(holder: ArticleHolder, position: Int) {
        getItem(position).let {
            holder.showArticle(it, onItemClick = onItemClick)
        }
    }

    override fun getItem(position: Int): ArticleItem {
        return super.getItem(position)!!
    }

    companion object {
         val DIFF_CALLBACK  = object: DiffUtil.ItemCallback<ArticleItem>(){
            override fun areItemsTheSame(oldItem: ArticleItem, newItem: ArticleItem): Boolean = oldItem == newItem
            override fun areContentsTheSame(oldItem: ArticleItem, newItem: ArticleItem): Boolean = oldItem.id == newItem.id
        }
    }

}
