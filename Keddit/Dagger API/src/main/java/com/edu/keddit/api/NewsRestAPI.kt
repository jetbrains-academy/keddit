package com.edu.Keddit.api

import retrofit2.Call
import javax.inject.Inject
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class NewsRestAPI @Inject constructor(private val redditApi: RedditApi) : NewsAPI {



    override fun getNews(after: String, limit: String): Call<RedditNewsResponse> {
        return redditApi.getTop(after, limit)
    }
}