package com.edu.Keddit.features.news

import com.edu.Keddit.commons.RedditNewsItem
import rx.Observable

class NewsManager() {

    fun getNews(): Observable<List<RedditNewsItem>> {
        return Observable.create {
           //Will be completed in the nest task
        }
    }
}