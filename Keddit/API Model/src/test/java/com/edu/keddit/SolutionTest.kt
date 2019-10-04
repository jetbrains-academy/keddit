package com.edu.keddit

import com.edu.keddit.api.RedditChildrenResponse
import com.edu.keddit.api.RedditDataResponse
import com.edu.keddit.api.RedditNewsResponse
import org.junit.Assert
import org.junit.Test
import java.lang.IllegalArgumentException

class SolutionTest {
    @Test
    fun testRedditNewsResponse() {
        var error: String? = null
        try {
            val result1 = RedditNewsResponse(RedditDataResponse(mutableListOf<RedditChildrenResponse>(),"",""))
            val result2 = RedditNewsResponse(RedditDataResponse(mutableListOf<RedditChildrenResponse>(),"", null))
            val result3 = RedditNewsResponse(RedditDataResponse(mutableListOf<RedditChildrenResponse>(),null,""))
        }
        catch (e: IllegalArgumentException) {
            error = e.message
        }
        Assert.assertNull("Check your RedditNewsResponse constructor arguments", error)
    }
    fun testRedditDataResponse() {
        var error: String? = null
        try {
            val result1 = RedditDataResponse(mutableListOf<RedditChildrenResponse>(),"","")
            val result2 = RedditDataResponse(mutableListOf<RedditChildrenResponse>(),"", null)
            val result3 = RedditDataResponse(mutableListOf<RedditChildrenResponse>(),null,"")
        }
        catch (e: IllegalArgumentException) {
            error = e.message
        }
        Assert.assertNull("Check your RedditNewsResponse constructor arguments", error)
    }
}
