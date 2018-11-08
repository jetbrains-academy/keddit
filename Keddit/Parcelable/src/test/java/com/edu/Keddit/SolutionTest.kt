package com.edu.Keddit

import android.os.Parcel
import android.os.Parcelable
import com.edu.Keddit.commons.RedditNews
import com.edu.Keddit.commons.RedditNewsItem
import kotlinx.android.synthetic.main.activity_main.view.*
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
