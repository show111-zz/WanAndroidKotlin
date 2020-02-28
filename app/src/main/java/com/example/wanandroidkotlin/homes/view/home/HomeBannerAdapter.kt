package com.example.wanandroidkotlin.homes.view.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.wanandroidkotlin.R
import com.example.wanandroidkotlin.homes.model.Banner
import kotlinx.android.synthetic.main.view_header_home_image.view.*

/**
 *  Created by hannah on 2020-02-28
 *  for the banner adapter
 */
class HomeBannerAdapter(bannerData: List<Banner>): RecyclerView.Adapter<HeaderBannerHolder>(){

    private var bannerData: List<Banner> = bannerData

    var onItemClick: ((Banner) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HeaderBannerHolder {
        val banner = LayoutInflater.from(parent.context).inflate(R.layout.view_header_home_image, parent, false)
        return HeaderBannerHolder(parent.context, banner)
    }

    override fun getItemCount(): Int = bannerData.size

    override fun onBindViewHolder(holder: HeaderBannerHolder, position: Int) {

        holder.header.setOnClickListener {
            onItemClick?.invoke(bannerData[position])
        }

        Glide.with(holder.header)
                .load(bannerData[position].imagePath)
                .into(holder.header.poster)
    }
}
