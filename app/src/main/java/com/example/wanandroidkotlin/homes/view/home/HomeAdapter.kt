package com.example.wanandroidkotlin.homes.view.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.wanandroidkotlin.R
import com.example.wanandroidkotlin.homes.model.ArticleItem
import com.example.wanandroidkotlin.homes.paging.AdapterDataObserverProxy

/**
 *  Created by hannah on 2020-02-07
 *  for the whole page
 */
class HomeAdapter : PagedListAdapter<ArticleItem, RecyclerView.ViewHolder>(DIFF_CALLBACK) {

    var onItemClick: ((ArticleItem) -> Unit)? = null

    override fun getItemViewType(position: Int): Int {
        return when (position) {
            0 -> ITEM_TYPE_HEADER
            else -> super.getItemViewType(position)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val header = LayoutInflater.from(parent.context).inflate(R.layout.view_header_home, parent, false)
        val articleView = LayoutInflater.from(parent.context).inflate(R.layout.view_item_article, parent, false)
        return when (viewType) {
            ITEM_TYPE_HEADER -> HeaderBannerHolder(parent.context, header)
            else -> ArticleHolder(articleView)
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is HeaderBannerHolder -> holder.bindHeader(getArticleItem(0)!!)
            is ArticleHolder -> holder.showArticle(getArticleItem(position)!!, onItemClick)
        }
    }

    private fun getArticleItem(position: Int): ArticleItem? {
        return super.getItem(position)
    }

    // 用来调用loadAfter()方法，所以需要重写
    override fun getItemCount(): Int {
        return super.getItemCount()
    }

    // 解决添加header时position位置不对的方法，传统请求接口的方式
    override fun registerAdapterDataObserver(observer: RecyclerView.AdapterDataObserver) {
        super.registerAdapterDataObserver(AdapterDataObserverProxy(observer, 1))
    }

    companion object {
        private const val ITEM_TYPE_HEADER = 100
        val DIFF_CALLBACK = object : DiffUtil.ItemCallback<ArticleItem>() {
            override fun areItemsTheSame(oldItem: ArticleItem, newItem: ArticleItem): Boolean =
                oldItem == newItem

            override fun areContentsTheSame(oldItem: ArticleItem, newItem: ArticleItem): Boolean =
                oldItem.id == newItem.id
        }
    }

}
