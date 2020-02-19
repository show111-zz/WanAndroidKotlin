package com.example.wanandroidkotlin.homes.model

data class TabBean(
    var `data`: List<Tab>,
    var errorCode: Int,
    var errorMsg: String
)

data class Tab(
    var children: List<Any>,
    var courseId: Int,
    var id: Int,
    var name: String,
    var order: Int,
    var parentChapterId: Int,
    var userControlSetTop: Boolean,
    var visible: Int
)
