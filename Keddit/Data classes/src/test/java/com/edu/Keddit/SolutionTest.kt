package com.edu.Keddit

import com.edu.Keddit.commons.RedditNewsItem
import kotlinx.android.synthetic.main.activity_main.view.*
import org.junit.Assert
import org.junit.Test
import java.lang.reflect.Type

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
