package com.edu.Keddit.features.news

import com.edu.Keddit.commons.RedditNewsItem
import rx.Observable

/**
 * News Manager allows you to request more news from Reddit.
 *
 * @author juancho
 */
class NewsManager() {

    fun getNews(): Observable<List<RedditNewsItem>> {
        return Observable.create {
           //Will be completed in the nest task
        }
    }
}