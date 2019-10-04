package com.edu.keddit

import com.edu.keddit.features.news.NewsManager
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner

@RunWith(RobolectricTestRunner::class)
open class SolutionTest {
    private var newsManager: NewsManager? = null
    @Before
    fun setup() {
        newsManager = NewsManager()
    }

    @Test
    fun testGetNewsReturnsObservable() {
        val news = newsManager?.getNews()
        val actualResult = rx.Observable::class.java.isInstance(news)
        Assert.assertTrue(actualResult)
    }

    @Test
    fun testGetNewsReturnsCreatedObservable() {
        val actualResult = newsManager?.getNews()?.subscribe()
        Assert.assertNotNull(actualResult)
    }
}


