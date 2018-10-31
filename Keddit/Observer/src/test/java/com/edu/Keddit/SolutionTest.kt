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

@RunWith(RobolectricTestRunner::class)
class SolutionTest {
    private var activity: MainActivity? = null
    private var newsFragment: NewsFragment? = null
    @Before
    fun setup() {
        activity = Robolectric.buildActivity(MainActivity::class.java).create().visible().start().get()
        newsFragment = activity?.supportFragmentManager!!.fragments[0] as NewsFragment
    }
    @Test
    fun testItemCountIs10() {
        val actualResult = activity?.news_list?.adapter?.itemCount
        Assert.assertEquals(11,actualResult)
    }
}