package com.edu.Keddit

import com.edu.Keddit.api.RedditApi
import kotlinx.android.synthetic.main.activity_main.view.*
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.lang.IllegalArgumentException

class SolutionTest {
    private var redditApi: RedditApi? = null

    @Before
    fun setUp() {
        val retrofit = Retrofit.Builder()
                .baseUrl("https://www.reddit.com")
                .addConverterFactory(MoshiConverterFactory.create())
                .build()

        redditApi = retrofit.create(RedditApi::class.java)
    }
    @Test
    fun testAfterAndLimit() {
        var error : String? = null
        try{
            redditApi?.getTop(after ="", limit= "")
        }
        catch (e: IllegalArgumentException){
            error = e.message
        }
        Assert.assertNull("You need to implement both \"after\" and \"limit\" values", error)
    }
    @Test
    fun testAfter() {
        var error : String? = null
        try{
            redditApi?.getTop("", limit= "")
        }
        catch (e: IllegalArgumentException){
            error = e.message
        }
        Assert.assertNull("You need to implement both \"after\" and \"limit\" values", error)
    }
    @Test
    fun testLimit() {
        var error : String? = null
        try{
            redditApi?.getTop("",  "")
        }
        catch (e: IllegalArgumentException){
            error = e.message
        }
        Assert.assertNull("You need to implement both \"after\" and \"limit\" values", error)
    }
}