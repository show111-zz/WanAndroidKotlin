package com.example.wanandroidkotlin.detail.view.project

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.wanandroidkotlin.R
import com.example.wanandroidkotlin.detail.model.ProjectData

/**
 *  Created by hannah on 2020-02-04
 */
class TabListAdapter : RecyclerView.Adapter<TabListViewHolder>(){

    private var tabList = listOf<ProjectData>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TabListViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.view_item_tab_list, parent, false)
       return TabListViewHolder(view)
    }

    override fun getItemCount(): Int = tabList.size

    override fun onBindViewHolder(holder: TabListViewHolder, position: Int) {
        holder.updateData(tabList[position])
    }

    fun setTabData(tabList: List<ProjectData>){
        this.tabList = tabList
    }

}
