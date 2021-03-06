package com.edu.keddit

import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner
import kotlinx.android.synthetic.main.news_fragment.*

@RunWith(RobolectricTestRunner::class)
class SolutionTest {
    private var activity: MainActivity? = null
    @Before
    fun setup() {
        activity = Robolectric.buildActivity(MainActivity::class.java).create().visible().start().get()
    }
    @Test
    fun testNewsNotNull() {
        val actualResult = activity?.news_list
        Assert.assertNotNull(actualResult)
    }
    @Test
    fun testHasFixedSize() {
        val actualResult = activity?.news_list
        Assert.assertTrue("Check if you apllied the code block to news_list inside onActivityCreated method",actualResult!!.hasFixedSize())
    }
}
