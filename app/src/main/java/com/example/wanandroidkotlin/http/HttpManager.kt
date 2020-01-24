package com.example.wanandroidkotlin.http

import com.example.wanandroidkotlin.BuildConfig
import com.example.wanandroidkotlin.http.interceptor.CacheInterceptor
import com.example.wanandroidkotlin.http.interceptor.CookieInterceptor
import com.example.wanandroidkotlin.http.interceptor.HeaderInterceptor
import dagger.Module
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

@Module
class HttpManager private constructor(){

    companion object {

        @Volatile
        private var httpManager:  HttpManager? = null

        /**also 返回的是传入的对象本身*/
        fun getHttpManager(): HttpManager{
            return httpManager ?: synchronized(this){
                httpManager ?: HttpManager().also {
                    httpManager = it
                }
            }
        }
    }

    fun retrofit(): ApiServices {
        val builder = OkHttpClient.Builder()
        if (BuildConfig.DEBUG) {
            val loggingInterceptor = HttpLoggingInterceptor()
            loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
            builder.addInterceptor(loggingInterceptor)
            builder.addInterceptor(CookieInterceptor())
            builder.addInterceptor(HeaderInterceptor())
            builder.addInterceptor(CacheInterceptor())
        }
        val okHttpClient = builder.build()
        val retrofit = Retrofit.Builder()
            .baseUrl(ApiServices.API_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(okHttpClient)
            .build()

        return retrofit.create(ApiServices::class.java)
    }
}
