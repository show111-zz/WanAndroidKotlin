package com.example.wanandroidkotlin.homes.view.knowledge

import android.content.Context
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.wanandroidkotlin.homes.model.Data
import com.example.wanandroidkotlin.utils.LabelText
import kotlinx.android.synthetic.main.view_item_knowledge.view.*

/**
 *  Created by hannah on 2020-01-28
 */
class KnowledgeViewHolder(
    private val knowledgeView: View,
    private var context: Context
) : RecyclerView.ViewHolder(knowledgeView){

    private var view: View = knowledgeView

    fun showKnowledge(data: Data) {
        view.name.text = data.name

        data.children.forEach {
            val label = LabelText(context)
            label.setChild(it)
            view.flowLayout.addView(label)
        }
    }

}
