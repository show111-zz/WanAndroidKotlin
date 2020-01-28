package com.example.wanandroidkotlin.detail.model

data class Knowledge(
    var `data`: List<Data>,
    var errorCode: Int,
    var errorMsg: String
)

data class Data(
    var children: List<Children>,
    var courseId: Int,
    var id: Int,
    var name: String,
    var order: Int,
    var parentChapterId: Int,
    var userControlSetTop: Boolean,
    var visible: Int
)

data class Children(
    var children: List<Any>,
    var courseId: Int,
    var id: Int,
    var name: String,
    var order: Int,
    var parentChapterId: Int,
    var userControlSetTop: Boolean,
    var visible: Int
)
