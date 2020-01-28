package com.example.wanandroidkotlin.detail.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.wanandroidkotlin.R
import com.example.wanandroidkotlin.detail.model.Data

/**
 *  Created by hannah on 2020-01-28
 */
class KnowledgeAdapter : RecyclerView.Adapter<KnowledgeViewHolder>(){

    private var knowledge = listOf<Data>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): KnowledgeViewHolder {
        var knowledgeView =
            LayoutInflater.from(parent.context).inflate(R.layout.view_item_knowledge, parent, false)
        return KnowledgeViewHolder(knowledgeView, parent.context)
    }

    override fun getItemCount(): Int = knowledge.size


    override fun onBindViewHolder(holder: KnowledgeViewHolder, position: Int) {
        holder.showKnowledge(knowledge[position])
    }


    fun setData(knowledge: List<Data>){
        this.knowledge = knowledge
    }

}
