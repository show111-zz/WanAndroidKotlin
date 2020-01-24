package com.example.wanandroidkotlin.http.interceptor

import com.example.wanandroidkotlin.http.Constants
import okhttp3.Interceptor
import okhttp3.Response


class CookieInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val response = chain.proceed(request)
        val requestUrl = request.url.toString()
        val host = request.url.host
        if ((requestUrl.contains(Constants.SAVE_USER_LOGIN_KEY)
                    || requestUrl.contains(Constants.SAVE_USER_REGISTER_KEY))
            && response.headers(Constants.COOKIE_HEADER_RESPONSE).isNotEmpty()
        ) {
            val cookies = response.headers(Constants.COOKIE_HEADER_RESPONSE)
            val cookie = Constants.encodeCookie(cookies)
            Constants.saveCookie(requestUrl, host, cookie)
        }
        return response
    }
}
