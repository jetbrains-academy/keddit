package com.edu.Keddit

import android.content.Context
import android.database.Observable
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.RelativeLayout
import com.edu.Keddit.commons.RedditNewsItem
import com.edu.Keddit.commons.inflate
import com.edu.Keddit.features.news.NewsFragment
import com.edu.Keddit.features.news.NewsManager
import org.junit.Assert
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner
import org.robolectric.util.ReflectionHelpers
import java.util.*
import kotlin.reflect.KClass
import kotlin.test.assertNull

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


