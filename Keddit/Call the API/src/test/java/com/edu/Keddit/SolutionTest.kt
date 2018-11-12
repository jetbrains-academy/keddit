package com.edu.Keddit

import com.edu.Keddit.api.RedditApi
import com.edu.Keddit.api.RestAPI
import com.edu.Keddit.features.news.NewsManager
import kotlinx.android.synthetic.main.activity_main.view.*
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class SolutionTest {
    private var newsManager: NewsManager? = null


    @Test
    fun testAfterAndLimit() {
        var error: String? = null
        try {
            newsManager = NewsManager(RestAPI())
        }
        catch (e: IllegalArgumentException) {
            error = e.message
        }
        Assert.assertNull(error)
    }
}