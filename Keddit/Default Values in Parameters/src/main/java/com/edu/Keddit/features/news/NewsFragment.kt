package com.edu.Keddit.features.news

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.news_fragment.*
import com.edu.Keddit.R
import com.edu.Keddit.commons.inflate


class NewsFragment : Fragment() {

    private val newsList by lazy {
        news_list
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup? , savedInstanceState: Bundle?): View? {
        return container?.inflate(R.layout.news_fragment)
    }
}