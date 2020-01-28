package com.example.wanandroidkotlin.detail.view

import android.content.Context
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.wanandroidkotlin.detail.model.Data
import com.example.wanandroidkotlin.utils.LabelText
import kotlinx.android.synthetic.main.view_item_knowledge.view.*

/**
 *  Created by hannah on 2020-01-28
 */
class KnowledgeViewHolder(
    private var knowledgeView: View,
    private var context: Context
) : RecyclerView.ViewHolder(knowledgeView){

    private var view: View = knowledgeView

    fun showKnowledge(data: Data) {
        view.name.text = data.name

        data.children.forEach {
            var label = LabelText(context)
            label.setName(it.name)
            view.flowLayout.addView(label)
        }

    }

}
