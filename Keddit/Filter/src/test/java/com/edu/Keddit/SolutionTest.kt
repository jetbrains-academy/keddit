package com.edu.keddit

import com.edu.keddit.api.adapter.test.NewsAdapter
import com.edu.keddit.commons.RedditNewsItem
import com.edu.keddit.commons.adapter.AdapterConstants
import com.edu.keddit.commons.adapter.ViewType
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.robolectric.Robolectric
import kotlinx.android.synthetic.main.news_fragment.*
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.util.ReflectionHelpers

@RunWith(RobolectricTestRunner::class)
class SolutionTest {
    private var activity: MainActivity? = null
    @Before
    fun setup() {
        activity = Robolectric.buildActivity(MainActivity::class.java).create().visible().start().get()
    }
    @Test
    fun testThereAre10BeforeAdd() {
        val actualResult  = (activity?.news_list?.adapter as NewsAdapter).getNews().size
        Assert.assertEquals(10, actualResult)
    }
    @Test
    fun testThereAre11AfterAddNEWS() {
        val newsToAdd = mutableListOf<RedditNewsItem>()
        newsToAdd.add(RedditNewsItem(
                    "author",
                    "Title ",
                    0, // number of comments
                    1457207701L - 12 * 200, // time
                    "http://lorempixel.com/200/200/technics/$", // image url
                    "url"
            ))
        (activity?.news_list?.adapter as NewsAdapter).addNews(newsToAdd)
        val items = ReflectionHelpers.getField<ArrayList<ViewType>>(activity?.news_list?.adapter, "items")
        val actualResult  = (activity?.news_list?.adapter as NewsAdapter).getNews().size
        Assert.assertEquals(items.size-1, actualResult)
    }
    @Test
    fun testThereAre10AfterAddNotNEWS() {
        val newsToAdd = mutableListOf<RedditNewsItem>()
        val notNews = object : ViewType {
            override fun getViewType() = AdapterConstants.LOADING
        }
        val items = ReflectionHelpers.getField<ArrayList<ViewType>>(activity?.news_list?.adapter, "items")
        items.add(notNews)
        (activity?.news_list?.adapter as NewsAdapter).addNews(newsToAdd)
        val actualResult  = (activity?.news_list?.adapter as NewsAdapter).getNews().size
        Assert.assertNotEquals(actualResult, items.size-1)
    }

}
