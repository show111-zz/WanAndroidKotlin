package com.example.wanandroidkotlin.base

/**
 *  Created by hannah on 2020-02-06
 */
enum class Status {
    LOADING,
    SUCCESS,
    ERROR
}

/** 一个通用类， 用于保存其具有加载状态的值*/
data class RequestState<out T>(val status: Status, val data: T?, val message: String? = null) {
    companion object {
        fun <T> loading(data: T? = null) = RequestState(Status.LOADING, data)
        fun <T> success(data: T? = null) = RequestState(Status.SUCCESS, data)
        fun <T> error(msg: String? = null, data: T? = null) = RequestState(Status.ERROR, data, msg)
    }
    fun isLoading(): Boolean = status == Status.LOADING
    fun isSuccess(): Boolean = status == Status.SUCCESS
    fun isError(): Boolean = status == Status.ERROR
}
