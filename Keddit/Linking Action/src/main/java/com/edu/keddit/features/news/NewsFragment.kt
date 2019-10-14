package com.edu.keddit.features.news

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.news_fragment.*
import com.edu.keddit.R
import com.edu.keddit.commons.inflate


class NewsFragment : androidx.fragment.app.Fragment() {

    private val newsList by lazy {
        news_list
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        //val view = inflater.inflate(R.layout.news_fragment, container, false)
        return container?.inflate(R.layout.news_fragment)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // Sending data from one fragment to another fragment
        view.setOnClickListener{
            Navigation.findNavController(view).navigate(R.id.action_newsFragment_to_postFragment)
        }
    }
}