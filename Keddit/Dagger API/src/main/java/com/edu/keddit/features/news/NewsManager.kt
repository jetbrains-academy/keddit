package com.edu.Keddit.features.news

import com.edu.Keddit.commons.RedditNewsItem
import com.edu.Keddit.api.RestAPI
import com.edu.Keddit.api.NewsAPI
import com.edu.Keddit.api.NewsRestAPI
import com.edu.Keddit.commons.RedditNews
import rx.Observable
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class NewsManager @Inject constructor(private val api: NewsAPI) {

    /**
     *
     * Returns Reddit News paginated by the given limit.
     *
     * @param after indicates the next page to navigate.
     * @param limit the number of news to request.
     */
    fun getNews(after: String, limit: String = "10"): Observable<RedditNews> {
        return Observable.create {
                subscriber ->
                val callResponse = api.getNews(after, limit)
                val response = callResponse.execute()

                if (response.isSuccessful) {
                    val dataResponse = response.body().data
                    val news = dataResponse.children.map {
                        val item = it.data
                        RedditNewsItem(item.author, item.title, item.num_comments,
                                item.created, item.thumbnail, item.url)
                    }
                    val redditNews = RedditNews(
                            dataResponse.after ?: "",
                            dataResponse.before ?: "",
                            news)

                    subscriber.onNext(redditNews)
                    subscriber.onCompleted()
                } else {
                    subscriber.onError(Throwable(response.message()))
            }
        }
    }
}