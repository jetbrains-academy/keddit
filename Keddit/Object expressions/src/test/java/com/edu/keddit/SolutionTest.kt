package com.edu.keddit

import com.edu.keddit.commons.RedditNewsItem
import org.junit.Assert
import org.junit.Test

class SolutionTest {
    @Test
    fun testSolution() {
        val redditNewsItem = RedditNewsItem("test")
        val actualResult = redditNewsItem.getViewType()
        Assert.assertEquals("getViewType() should return News constant from AdapterConstants.kt. Check it out.",1, actualResult)
    }
}
