package com.example.wanandroidkotlin.base

import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.rxkotlin.addTo

/**
 *  Created by hannah on 2020-01-21
 */
abstract class BaseViewModel : ViewModel() {

    private val compositeDisposable = CompositeDisposable()

    protected fun Disposable.disposeOnClear() = addTo(compositeDisposable)

    override fun onCleared() {
        compositeDisposable.clear()
    }
}
