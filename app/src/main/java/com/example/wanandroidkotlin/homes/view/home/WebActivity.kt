package com.example.wanandroidkotlin.homes.view.home

import android.view.View
import android.webkit.WebView
import android.webkit.WebViewClient
import com.example.wanandroidkotlin.R
import com.example.wanandroidkotlin.base.BaseActivity
import kotlinx.android.synthetic.main.activity_web_view.*

/**
 *  Created by hannah on 2020-02-21
 */
class WebActivity : BaseActivity(){

    private lateinit var linkUrl: String

    override var layoutId: Int = R.layout.activity_web_view

    override fun initData() {
       linkUrl = intent.getStringExtra("link") ?: "www.google.com"

        setupWebView()
    }

    private fun setupWebView() {
        webView.webViewClient = object : WebViewClient(){
            override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
                view?.loadUrl(url)
                return true
            }

            override fun onPageFinished(view: WebView?, url: String?) {
                super.onPageFinished(view, url)
                progressBar?.visibility = View.GONE
            }
        }
        webView.loadUrl(linkUrl)
    }

}
