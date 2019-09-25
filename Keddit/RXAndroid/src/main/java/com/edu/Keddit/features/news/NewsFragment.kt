package com.edu.keddit.features.news

import com.google.android.material.snackbar.Snackbar
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.edu.keddit.R
import com.edu.keddit.commons.inflate
import com.edu.keddit.api.adapter.test.NewsAdapter
import kotlinx.android.synthetic.main.news_fragment.*
import rx.schedulers.Schedulers
import rx.android.schedulers.AndroidSchedulers


class NewsFragment : androidx.fragment.app.Fragment() {

    private val newsManager by lazy { NewsManager() }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return container?.inflate(R.layout.news_fragment)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        news_list.setHasFixedSize(true)
        news_list.layoutManager = androidx.recyclerview.widget.LinearLayoutManager(context)
        initAdapter()

        if (savedInstanceState == null) {
            requestNews()
        }
    }

    private fun requestNews() {
        val subscription = newsManager.getNews()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe (
                        { retrievedNews ->
                            (news_list.adapter as NewsAdapter).addNews(retrievedNews)
                        },
                        { e ->
                            Snackbar.make(news_list, e.message ?: "", Snackbar.LENGTH_LONG).show()
                        }
                )
    }

    private fun initAdapter() {
        if (news_list.adapter == null) {
            news_list.adapter = NewsAdapter()
        }
    }
}