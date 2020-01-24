package com.example.wanandroidkotlin.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.rxkotlin.addTo

/**
 *  Created by hannah on 2020-01-21
 */
abstract class BaseActivity : AppCompatActivity() {

    private val compositeDisposable = CompositeDisposable()

    protected abstract var layoutId: Int

    protected abstract fun initData()

    protected abstract fun subscribeUi()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layoutId)
        initData()
        subscribeUi()
    }

    protected fun Disposable.disposeOnClear() = addTo(compositeDisposable)

    override fun onDestroy() {
        super.onDestroy()
        if (!compositeDisposable.isDisposed) {
            compositeDisposable.clear()
        }
    }



}
