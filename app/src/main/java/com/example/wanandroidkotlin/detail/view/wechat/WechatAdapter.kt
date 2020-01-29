package com.example.wanandroidkotlin.detail.view.wechat

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.wanandroidkotlin.R
import com.example.wanandroidkotlin.detail.model.WechatX

/**
 *  Created by hannah on 2020-01-29
 */
class WechatAdapter : RecyclerView.Adapter<WechatViewHolder>(){

    private var wechatList = listOf<WechatX>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WechatViewHolder {
         var wechatView = LayoutInflater.from(parent.context).inflate(R.layout.view_item_wechat, parent, false)
        return WechatViewHolder(wechatView)
    }

    override fun getItemCount(): Int = wechatList.size


    override fun onBindViewHolder(holder: WechatViewHolder, position: Int) {
        holder.showData(wechatList[position])
    }

    fun setData(wechatList: List<WechatX>){
        this.wechatList = wechatList
    }

}
