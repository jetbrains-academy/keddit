package com.edu.keddit

import com.edu.keddit.api.NewsAPI
import javax.inject.Inject

class TestNewsManager {
    @Inject lateinit var api: NewsAPI
    fun returnApi() : NewsAPI {

        return api
    }
}