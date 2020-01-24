package com.example.wanandroidkotlin.http

import com.example.wanandroidkotlin.utils.SharedPreferencesUtils

/**
 *  Created by hannah on 2020-01-17
 */
object Constants {

    const val BASE_URL = "https://www.wanandroid.com/"
    const val NETWORK_TIME = 60
    const val CACHE_NAME = "wanandroid-mvvm"
    const val MAX_CACHE_SIZE = 50

    const val SAVE_USER_LOGIN_KEY = "user/login"
    const val SAVE_USER_REGISTER_KEY = "user/register"

    val LOGIN_REQUIRED_URLS = arrayOf("lg/collect", "lg/uncollect", "lg/todo")

    const val COOKIE_HEADER_RESPONSE = "set-cookie"
    const val COOKIE_HEADER_REQUEST = "Cookie"


    fun encodeCookie(cookies: List<String>): String {
        val sb = StringBuilder()
        val set = HashSet<String>()
        cookies
            .map { cookie ->
                cookie.split(";".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
            }
            .forEach {
                it.filterNot { set.contains(it) }.forEach { set.add(it) }
            }
        val ite = set.iterator()
        while (ite.hasNext()) {
            val cookie = ite.next()
            sb.append(cookie).append(";")
        }
        val last = sb.lastIndexOf(";")
        if (sb.length - 1 == last) {
            sb.deleteCharAt(last)
        }
        return sb.toString()
    }

    fun saveCookie(url: String?, host: String?, cookies: String) {
        url ?: return
        SharedPreferencesUtils(url, cookies)
        host ?: return
        SharedPreferencesUtils(host, cookies)
    }


}
