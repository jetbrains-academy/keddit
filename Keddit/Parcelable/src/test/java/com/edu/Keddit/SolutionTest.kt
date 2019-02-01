package com.edu.keddit

import android.os.Parcelable
import com.edu.keddit.commons.RedditNews
import com.edu.keddit.commons.RedditNewsItem
import org.junit.Assert
import org.junit.Test

class SolutionTest {
    @Test
    fun testRedditNewsAsParcelable() {
        var error: String? = null
        val parcelable = RedditNews("","", mutableListOf())
        try {
            var actualresult = parcelable as Parcelable
        }
        catch (e: Exception){
            error = e.message
        }
        Assert.assertNull(error, error)
    }
    @Test
    fun testRedditNewsItemAsParcelable() {
        var error: String? = null
        val parcelable = RedditNewsItem("","",0, 0L, "", "")
        try {
            var actualresult = parcelable as Parcelable
        }
        catch (e: Exception){
            error = e.message
        }
        Assert.assertNull(error, error)
    }
}