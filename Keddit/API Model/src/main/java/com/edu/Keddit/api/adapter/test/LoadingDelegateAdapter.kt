package com.edu.keddit.api.adapter.test


import androidx.recyclerview.widget.RecyclerView
import android.view.ViewGroup
import com.edu.keddit.commons.adapter.ViewType
import com.edu.keddit.commons.adapter.ViewTypeDelegateAdapter
import com.edu.keddit.R
import com.edu.keddit.commons.inflate

class LoadingDelegateAdapter : ViewTypeDelegateAdapter {

    override fun onCreateViewHolder(parent: ViewGroup) = TurnsViewHolder(parent)

    override fun onBindViewHolder(holder: androidx.recyclerview.widget.RecyclerView.ViewHolder, item: ViewType) {
    }

    class TurnsViewHolder(parent: ViewGroup) : androidx.recyclerview.widget.RecyclerView.ViewHolder(
            parent.inflate(R.layout.news_item_loading)) {
    }
}