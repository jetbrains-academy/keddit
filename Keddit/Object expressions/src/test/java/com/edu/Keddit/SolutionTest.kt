package com.edu.Keddit

import com.edu.Keddit.commons.RedditNewsItem
import kotlinx.android.synthetic.main.activity_main.view.*
import org.junit.Assert
import org.junit.Test

class SolutionTest {
    @Test
    fun testSolution() {
        val redditNewsItem = RedditNewsItem("test", "test", 1, 2, "test", "test")
        val actualResult = redditNewsItem.getViewType()
        Assert.assertEquals("getViewType() should return News constant from AdapterConstants.kt. Check it out.",1, actualResult)
    }
}
