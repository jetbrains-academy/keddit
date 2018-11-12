package com.edu.Keddit

import com.edu.Keddit.api.RedditChildrenResponse
import com.edu.Keddit.api.RedditDataResponse
import com.edu.Keddit.api.RedditNewsResponse
import kotlinx.android.synthetic.main.activity_main.view.*
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
