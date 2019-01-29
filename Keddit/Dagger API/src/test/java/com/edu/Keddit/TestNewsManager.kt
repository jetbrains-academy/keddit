package com.edu.Keddit

import com.edu.Keddit.api.NewsAPI
import javax.inject.Inject

class TestNewsManager {
    @Inject lateinit var api: NewsAPI
    fun returnApi() : NewsAPI {

        return api
    }
}