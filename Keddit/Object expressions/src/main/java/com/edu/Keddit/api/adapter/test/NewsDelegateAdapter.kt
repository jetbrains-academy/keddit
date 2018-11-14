package com.edu.Keddit.api.adapter.test


import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import com.edu.Keddit.R
import com.edu.Keddit.commons.RedditNewsItem
import com.edu.Keddit.commons.adapter.ViewType
import com.edu.Keddit.commons.adapter.ViewTypeDelegateAdapter
import com.edu.Keddit.commons.extensions.getFriendlyTime
import com.edu.Keddit.commons.inflate
import com.edu.Keddit.commons.loadImg
import kotlinx.android.synthetic.main.news_item.view.*

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