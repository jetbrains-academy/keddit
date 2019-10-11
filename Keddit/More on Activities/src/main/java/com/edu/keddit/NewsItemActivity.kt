package com.edu.keddit

import android.os.Bundle
import android.webkit.WebView
import androidx.appcompat.app.AppCompatActivity

class NewsItemActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val postWebView = WebView(applicationContext)
        postWebView.settings.javaScriptEnabled = true
        postWebView.settings.javaScriptCanOpenWindowsAutomatically = true
        postWebView.loadUrl("https://www.reddit.com/")
        setContentView(postWebView)
    }
}