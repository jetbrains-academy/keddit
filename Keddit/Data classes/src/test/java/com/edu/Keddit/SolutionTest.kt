package com.edu.keddit

import com.edu.keddit.commons.RedditNewsItem
import org.junit.Assert
import org.junit.Test

class SolutionTest {
    @Test
    fun testProperties() {
        var actualResult: IllegalArgumentException? = null
        try {
            val redditNewsItem = RedditNewsItem("test", "test", 1, 2, "test", "test")
        }
        catch (e: IllegalArgumentException) {
            actualResult = e
        }
        Assert.assertNull("Check the properties of the RedditNewsItem",actualResult)
    }
    @Test
    fun testIfIsDataClass() {
        val actualResult = RedditNewsItem::class
        Assert.assertTrue("", actualResult.isData)
    }
}
