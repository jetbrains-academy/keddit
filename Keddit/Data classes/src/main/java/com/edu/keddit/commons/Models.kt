package com.edu.Keddit.commons

import com.edu.Keddit.commons.adapter.AdapterConstants
import com.edu.Keddit.commons.adapter.ViewType

data class RedditNewsItem(
        val author: String,
        val title: String,
        val numComments: Int,
        val created: Long,
        val thumbnail: String,
        val url: String
) : ViewType {
    override fun getViewType() = AdapterConstants.NEWS
}
