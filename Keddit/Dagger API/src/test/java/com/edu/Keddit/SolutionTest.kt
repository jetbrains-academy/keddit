package com.edu.Keddit

import com.edu.Keddit.di.news.DaggerNewsComponent
import org.junit.Assert
import org.junit.Test

class SolutionTest {

    @Test
    fun testNewsComponentIsNotNull() {
        var actualResult = DaggerNewsComponent.builder().build()
        Assert.assertNotNull("Check out the implementation of NewsComponent", actualResult)
    }
}
