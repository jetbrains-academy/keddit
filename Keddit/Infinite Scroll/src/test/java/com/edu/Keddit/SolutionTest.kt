package com.edu.keddit

import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.edu.keddit.commons.InfiniteScrollListener
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner
import kotlinx.android.synthetic.main.news_fragment.*
import java.lang.IllegalArgumentException

@RunWith(RobolectricTestRunner::class)
class SolutionTest {
    private var activity: MainActivity? = null
    private var infiniteScrollListener: InfiniteScrollListener? = null
    @Before
    fun setup() {
        activity = Robolectric.buildActivity(MainActivity::class.java).create().visible().start().get()

    }
    @Test
    fun testInfiniteScrollListenerParameters() {
        var error: String? = null
        try {
            infiniteScrollListener = InfiniteScrollListener({test()}, LinearLayoutManager(activity?.baseContext) )
        }
        catch (e: IllegalArgumentException){
            error = e.message
        }
        Assert.assertNull("Check what arguments does the constructor of InfiniteScrollListener take.",error)
    }
    @Test
    fun testListenerAttached() {
        val actualResult = activity?.news_list
        var listenerField = RecyclerView::class.java.getDeclaredField("mScrollListeners")
        listenerField.isAccessible = true
        val actualListener = (listenerField.get(actualResult) as ArrayList<*>)[0]
        Assert.assertTrue("Check if ",InfiniteScrollListener::class.java.isInstance(actualListener))
    }

    private fun test() {    }
}
