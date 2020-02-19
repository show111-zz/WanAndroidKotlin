package com.example.wanandroidkotlin.homes.view.wechat

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.wanandroidkotlin.homes.model.WechatX
import kotlinx.android.synthetic.main.view_item_wechat.view.*

/**
 *  Created by hannah on 2020-01-29
 */
class WechatViewHolder(private val wechatView: View) : RecyclerView.ViewHolder(wechatView){

    fun showData(wechatX: WechatX) {
        wechatView.title.text = wechatX.title
        wechatView.author.text = wechatX.author
        wechatView.date.text = wechatX.niceDate
    }

}
