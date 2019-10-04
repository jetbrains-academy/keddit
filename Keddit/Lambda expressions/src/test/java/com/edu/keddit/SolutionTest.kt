package com.edu.keddit

import com.edu.keddit.commons.RedditNewsItem
import com.edu.keddit.features.news.NewsManager
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
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