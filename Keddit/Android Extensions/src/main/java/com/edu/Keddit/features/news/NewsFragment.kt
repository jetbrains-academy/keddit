package com.edu.keddit.features.news

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.edu.keddit.R
import com.edu.keddit.commons.inflate


class NewsFragment : androidx.fragment.app.Fragment() {

    private var newsList : androidx.recyclerview.widget.RecyclerView? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = container?.inflate(R.layout.news_fragment)
        newsList = view?.findViewById(R.id.news_list)
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        newsList?.setHasFixedSize(true)
        newsList?.layoutManager = androidx.recyclerview.widget.LinearLayoutManager(context)
    }
}