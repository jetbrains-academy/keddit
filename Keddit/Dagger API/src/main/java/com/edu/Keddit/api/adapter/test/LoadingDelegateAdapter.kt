package com.edu.Keddit.api.adapter.test


import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import com.edu.Keddit.commons.adapter.ViewType
import com.edu.Keddit.commons.adapter.ViewTypeDelegateAdapter
import com.edu.Keddit.R
import com.edu.Keddit.commons.inflate

class LoadingDelegateAdapter : ViewTypeDelegateAdapter {

    override fun onCreateViewHolder(parent: ViewGroup) = TurnsViewHolder(parent)

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, item: ViewType) {
    }

    class TurnsViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder(
            parent.inflate(R.layout.news_item_loading)) {
    }
}