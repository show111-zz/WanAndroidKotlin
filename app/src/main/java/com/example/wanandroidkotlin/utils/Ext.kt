package com.example.wanandroidkotlin.utils

import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 *  Created by hannah on 2020-01-23
 */
fun <T> Observable<T>.async(): Observable<T> {
    return this.subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
}

fun <T> Observable<T>.asyncSubscribe(onNext: (T) -> Unit, onError: (Throwable) -> Unit) {

    this.async().subscribe {
        onNext(it)
    }

//    this.async()
//        .subscribe(object : RxHttpObserver<T>() {
//            override fun onNext(it: T) {
//                super.onNext(it)
//                onNext(it)
//            }
//
//            override fun onError(e: Throwable) {
//                super.onError(e)
//                onError(e)
//            }
//        })
}
