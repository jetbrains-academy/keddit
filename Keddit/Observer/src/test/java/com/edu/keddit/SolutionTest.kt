package com.edu.keddit

import com.edu.keddit.features.news.NewsFragment
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.robolectric.Robolectric
import kotlinx.android.synthetic.main.news_fragment.*
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner

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