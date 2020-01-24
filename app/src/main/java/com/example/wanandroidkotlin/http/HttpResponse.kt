package com.example.wanandroidkotlin.http

/**
 *  Created by hannah on 2020-01-23
 */
data class HttpResponse<T> (
    var data: T?,
    var errorCode: Int,
    var errorMsg: String?
)

