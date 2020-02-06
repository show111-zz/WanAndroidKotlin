package com.example.wanandroidkotlin.utils

import android.os.Handler
import android.os.Looper
import java.util.concurrent.Executors

/**
 *  Created by hannah on 2020-02-06
 */
object ExecutorUtils {
    var NETWORK_IO = Executors.newFixedThreadPool(5)
    fun main_thread(runnable: Runnable, delay: Long = 0){
        Handler(Looper.getMainLooper()).postDelayed(runnable, delay)
    }
}
