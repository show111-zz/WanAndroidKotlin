package com.example.wanandroidkotlin.homes.model

/**
 *  Created by hannah on 2020-01-17
 */
data class BannerBean(
    val data: List<Banner> = emptyList(),
    val errorCode : Int,
    val errorMsg: String
)

data class Banner(
    var desc: String,
    var id: Int,
    var imagePath: String,
    var isVisible: Int,
    var order: Int,
    var title: String,
    var type: Int,
    var url: String
)


