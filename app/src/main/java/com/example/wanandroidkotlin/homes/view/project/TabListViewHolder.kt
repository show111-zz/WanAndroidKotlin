package com.example.wanandroidkotlin.homes.view.project

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.wanandroidkotlin.homes.model.ProjectData
import kotlinx.android.synthetic.main.view_item_tab_list.view.*

/**
 *  Created by hannah on 2020-02-04
 */
class TabListViewHolder(private val tabListview: View) : RecyclerView.ViewHolder(tabListview){

    fun updateData(projectData: ProjectData) {
        tabListview.author.text = projectData.author
        tabListview.date.text = projectData.niceDate
        tabListview.title.text = projectData.title
        tabListview.content.text = projectData.desc
        tabListview.category.text = projectData.chapterName
        Glide.with(tabListview)
            .load(projectData.link)
            .into(tabListview.image)
    }

}
