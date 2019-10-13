package com.edu.keddit.features.news

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation.findNavController
import androidx.navigation.findNavController
import com.edu.keddit.R
import com.edu.keddit.commons.inflate
import kotlinx.android.synthetic.main.news_fragment.*


class NewsFragment : androidx.fragment.app.Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = container?.inflate(R.layout.news_fragment)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Sending data from one fragment to another fragment
        view.setOnClickListener{

                findNavController(view).navigate(R.id.action_newsFragment_to_postFragment)

        }
    }

}