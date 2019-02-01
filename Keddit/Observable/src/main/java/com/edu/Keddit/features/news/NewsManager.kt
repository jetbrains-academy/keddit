package com.edu.keddit.features.news

import com.edu.keddit.commons.RedditNewsItem
import rx.Observable

class NewsManager() {

    fun getNews(): Observable<List<RedditNewsItem>> {
        return Observable.create {
           //Will be completed in the nest task
        }
    }
}