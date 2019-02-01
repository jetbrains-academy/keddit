package com.edu.keddit

import com.edu.keddit.api.RedditApi
import com.edu.keddit.api.RestAPI
import org.junit.Assert
import org.junit.Before
import org.junit.Test

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