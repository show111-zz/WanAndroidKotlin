package com.example.wanandroidkotlin.homes.view.home

import android.content.Context
import android.content.Intent
import android.os.Handler
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.example.wanandroidkotlin.homes.model.ArticleItem
import kotlinx.android.synthetic.main.view_header_home.view.*
import java.util.*

/**
 *  Created by hannah on 2020-02-19
 */
class HeaderBannerHolder(context: Context, header: View) : RecyclerView.ViewHolder(header) {

    val header: View = header
    val context = context

    private lateinit var bannerAdapter: HomeBannerAdapter

    private lateinit var viewpager: ViewPager2

    private val handler: Handler = Handler()


    fun bindHeader(article: ArticleItem) {

        viewpager = header.viewpager2

        if (article.bannerData.isNotEmpty()) {
            bannerAdapter = HomeBannerAdapter(article.bannerData)
        }
        viewpager.adapter = bannerAdapter

        autoScroll()

       bannerAdapter.onItemClick= {
           context.startActivity(Intent(context, WebActivity::class.java).putExtra("link", it.url))
       }
    }

    private fun autoScroll() {
        var page = 0
        val time = object : TimerTask() {
            override fun run() {
                handler.post(Runnable() {
                    page = (page + 1) % bannerAdapter.itemCount
                    viewpager.currentItem = page
                })
            }
        }
        val timer = Timer()
        timer.schedule(time, 0, 3000)
    }
}
