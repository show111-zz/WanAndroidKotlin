package com.example.wanandroidkotlin.http

import com.example.wanandroidkotlin.AppApplication
import com.example.wanandroidkotlin.utils.NetUtils
import org.reactivestreams.Subscriber
import org.reactivestreams.Subscription
import retrofit2.HttpException
import java.lang.RuntimeException

/**
 *  Created by hannah on 2020-01-21
 */
abstract class ApiCallback<M>  : Subscriber<M>{
    abstract fun onSuccess(model: M)
    abstract fun onFailure(msg: String?)
    abstract fun onFinish()

    override fun onComplete() {
        onFinish()
    }

    override fun onNext(t: M) {
        onSuccess(t)
    }

    override fun onError(t: Throwable?) {
        if (t is HttpException) {
            val httpException = t
//            val code = httpException.code()
            val msg = httpException.message()
            onFailure(msg)
        } else {
            onFailure(t.toString())
        }
        onFinish()
    }

    override fun onSubscribe(s: Subscription?) {
        if(!NetUtils.isNetworkAvailable(AppApplication.instance)){
            onError(RuntimeException("网络连接不可用"))
        }
    }
}
