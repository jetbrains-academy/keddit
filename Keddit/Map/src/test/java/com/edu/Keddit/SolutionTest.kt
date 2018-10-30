package com.edu.Keddit

import android.support.v7.widget.RecyclerView
import com.edu.Keddit.api.adapter.test.NewsAdapter
import com.edu.Keddit.commons.RedditNewsItem
import com.edu.Keddit.commons.adapter.AdapterConstants
import com.edu.Keddit.commons.adapter.ViewType
import com.edu.Keddit.features.news.NewsFragment
import kotlinx.android.synthetic.main.activity_main.view.*
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
    fun testShouldThroughClassCastExceptionAfterAddNotNEWS() {
        val newsToAdd = mutableListOf<ViewType>()
        newsToAdd.add(NotRedditNewsItem(
                "author",
                "Title ",
                0, // number of comments
                1457207701L - 12 * 200, // time
                "http://lorempixel.com/200/200/technics/$", // image url
                "url"
        ))
        (activity?.news_list?.adapter as NewsAdapter).addNews(newsToAdd)
        val items = ReflectionHelpers.getField<ArrayList<ViewType>>(activity?.news_list?.adapter, "items")
        var actualResult: String? = "correct"
        try {val actualResult  = (activity?.news_list?.adapter as NewsAdapter).getNews()}
        catch (e :ClassCastException){
            actualResult = e.message
        }
        Assert.assertEquals("com.edu.Keddit.SolutionTest\$NotRedditNewsItem cannot be cast to com.edu.Keddit.commons.RedditNewsItem", actualResult)
    }

    private data class NotRedditNewsItem(
            val author: String,
            val title: String,
            val numComments: Int,
            val created: Long,
            val thumbnail: String,
            val url: String
    ) : ViewType {
        override fun getViewType() = AdapterConstants.NEWS
    }

}
