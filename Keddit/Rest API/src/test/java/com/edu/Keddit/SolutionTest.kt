package com.edu.Keddit

import com.edu.Keddit.api.RedditApi
import com.edu.Keddit.api.RestAPI
import kotlinx.android.synthetic.main.activity_main.view.*
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class SolutionTest {
    private var restApi: RestAPI? = null

    @Before
    fun setUp() {
        restApi = RestAPI()
    }
    @Test
    fun testInit() {
        var actualResult = RestAPI::class.java.getDeclaredField("redditApi")
        actualResult.isAccessible = true
        var actualField : RedditApi? = null
        try{
            actualField = actualResult.get(restApi) as RedditApi}
        catch (e: NoSuchFieldException) {
            actualField = null
        }
        Assert.assertTrue(RedditApi::class.java.isInstance(actualField))
    }
}