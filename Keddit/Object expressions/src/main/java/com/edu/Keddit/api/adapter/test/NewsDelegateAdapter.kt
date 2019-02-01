package com.edu.keddit.api.adapter.test


import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import com.edu.keddit.R
import com.edu.keddit.commons.RedditNewsItem
import com.edu.keddit.commons.adapter.ViewType
import com.edu.keddit.commons.adapter.ViewTypeDelegateAdapter
import com.edu.keddit.commons.inflate

class NewsDelegateAdapter : ViewTypeDelegateAdapter {

    override fun onCreateViewHolder(parent: ViewGroup): RecyclerView.ViewHolder {
        return TurnsViewHolder(parent)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, item: ViewType) {
        holder as TurnsViewHolder
        holder.bind(item as RedditNewsItem)
    }

    class TurnsViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder(
            parent.inflate(R.layout.news_item)) {

        fun bind(item: RedditNewsItem) = with(itemView) {
            //Picasso.with(itemView.context).load(item.thumbnail).into(img_thumbnail)
        }
    }
}