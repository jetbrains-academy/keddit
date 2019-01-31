package com.edu.Keddit

import com.edu.Keddit.api.NewsAPI
import com.edu.Keddit.api.RedditNewsResponse
import kotlinx.android.synthetic.main.activity_main.view.*
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.mockito.MockingDetails
import org.mockito.Mockito
import retrofit2.Call
import java.lang.reflect.Field

class SolutionTest {
    private var testNewsManagerTest: NewsManagerTest? = null
    private var testMockNewsApi: Field? = null
    private var testMockCallApi: Field? = null

    @Before
    fun setup() {
        testNewsManagerTest = NewsManagerTest()
    }
    @Test
    fun testNewsApiMocked() {
        testMockNewsApi = NewsManagerTest::class.java.getDeclaredField("apiMock")
        testMockNewsApi?.isAccessible = true
        val actualResult = testMockNewsApi?.get(testNewsManagerTest)
        Assert.assertTrue("Checkout If you used mock() correctly, the newsApi is not mocked properly.", Mockito.mockingDetails(actualResult).isMock)
        Assert.assertTrue("Checkout if you mocked NewsAPI, the type of apiMock seems to be incorrect.", NewsAPI::class.java.isInstance(actualResult))
    }

    @Test
    fun testCallMocked() {
        testMockCallApi = NewsManagerTest::class.java.getDeclaredField("callMock")
        testMockCallApi?.isAccessible = true
        val actualResult = testMockCallApi?.get(testNewsManagerTest)
        Assert.assertTrue("Checkout If you used mock() correctly, the Call<RedditNewsResponse> is not mocked properly.", Mockito.mockingDetails(actualResult).isMock)
        Assert.assertTrue("Checkout if you mocked NewsAPI, the type of callMock seems to be incorrect.", Call::class.java.isInstance(actualResult))
    }
}
