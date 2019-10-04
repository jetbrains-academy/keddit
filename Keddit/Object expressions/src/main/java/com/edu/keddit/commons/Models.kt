package com.edu.keddit.commons

import com.edu.keddit.commons.adapter.AdapterConstants
import com.edu.keddit.commons.adapter.ViewType

data class RedditNewsItem(
        val url: String
) : ViewType {
    override fun getViewType() = AdapterConstants.NEWS
}
