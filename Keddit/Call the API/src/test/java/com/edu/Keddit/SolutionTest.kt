package com.edu.keddit

import com.edu.keddit.api.RestAPI
import com.edu.keddit.features.news.NewsManager
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import java.lang.IllegalArgumentException

class SolutionTest {
    private var restApi: RestAPI? = null
    private var newsManager: NewsManager? = null

    @Before
    fun setUp() {
        restApi = RestAPI()
        newsManager = NewsManager()
    }
    @Test
    fun testNewsManagerConstructorWithParameter() {
        var error: String? = null
        try {
            NewsManager(restApi!!)
        } catch (e: IllegalArgumentException) {
            error = e.message
        }
        Assert.assertNull("CHeckout that the NewsManager constructor accepts RestAPI as the parameter.",error)
    }
    @Test
    fun testNewsManagerConstructorWithoutParameter() {
        var actualResult = NewsManager::class.java.getDeclaredField("api")
        actualResult.isAccessible = true
        var actualField : RestAPI? = null
        try{
            actualField = actualResult.get(newsManager) as RestAPI}
        catch (e: NoSuchFieldException) {
            actualField = null
        }
        Assert.assertTrue(RestAPI::class.java.isInstance(actualField))
    }
}