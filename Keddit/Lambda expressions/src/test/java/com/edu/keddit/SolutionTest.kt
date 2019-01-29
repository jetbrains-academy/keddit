package com.edu.Keddit

import android.support.v7.widget.RecyclerView
import com.edu.Keddit.api.adapter.test.NewsAdapter
import com.edu.Keddit.commons.RedditNewsItem
import com.edu.Keddit.commons.adapter.AdapterConstants
import com.edu.Keddit.commons.adapter.ViewType
import com.edu.Keddit.features.news.NewsFragment
import com.edu.Keddit.features.news.NewsManager
import kotlinx.android.synthetic.main.activity_main.view.*
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.robolectric.Robolectric
import kotlinx.android.synthetic.main.news_fragment.*
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.util.ReflectionHelpers
import rx.Observable
import rx.observers.TestSubscriber

@RunWith(RobolectricTestRunner::class)
class SolutionTest {
    private var newsManager: NewsManager? = null
    @Before
    fun setup() {
        newsManager = NewsManager()
    }
    @Test
    fun testCanSubscribeOnNewsManager() {
        val actualResult  = newsManager?.getNews()?.subscribe()
        Assert.assertNotNull(actualResult)
    }
    @Test
    fun testSubscriberGetsNewsFromNewsManager() {
        val testSubscriber = TestSubscriber<List<RedditNewsItem>>()

        val actualNews  = newsManager?.getNews()
        actualNews?.subscribe(testSubscriber)

        val listOfNews  = mutableListOf<RedditNewsItem>()
        for (i in 1..10) {
            listOfNews.add(RedditNewsItem(
                    "author$i",
                    "Title $i",
                    i, // number of comments
                    1457207701L - i * 200, // time
                    "http://lorempixel.com/200/200/technics/$i", // image url
                    "url"
            ))
        }
        val expectedNews = mutableListOf<List<RedditNewsItem>>()
        expectedNews.add(listOfNews)

        testSubscriber.assertReceivedOnNext(expectedNews)
        //Assert.assertTrue(actualResult)
    }
}