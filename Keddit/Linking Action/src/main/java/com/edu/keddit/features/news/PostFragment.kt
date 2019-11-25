package com.edu.keddit.features.news

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.edu.keddit.R
import android.webkit.WebViewClient
import android.webkit.WebView




class PostFragment : androidx.fragment.app.Fragment() {

    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.post_fragment, container, false)
        val mWebView = view.findViewById<WebView>(R.id.webview)
        mWebView.loadUrl("https://www.reddit.com/")

        // Enable Javascript
        val webSettings = mWebView.getSettings()
        webSettings.javaScriptEnabled = true

        return view
    }
}