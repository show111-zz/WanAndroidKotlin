package com.example.wanandroidkotlin.homes.view

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.wanandroidkotlin.data.DataX
import kotlinx.android.synthetic.main.view_item_article.view.*

/**
 *  Created by hannah on 2020-01-24
 */
class ArticleHolder(articleView: View):  RecyclerView.ViewHolder(articleView){

    private var view: View = articleView

    fun showArticle(
        dataX: DataX,
        onItemClick: ((DataX) -> Unit)?
    ) {
        view.articleView.text = dataX.title
        view.setOnClickListener {
            onItemClick?.invoke(dataX)
        }

    }

}
