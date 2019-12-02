package com.edu.keddit

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.webkit.WebView
import com.edu.keddit.features.news.NewsFragment
import com.edu.keddit.features.news.PostFragment
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner

@RunWith(RobolectricTestRunner::class)
class SolutionTest {
    private var postFragment: PostFragment? = null
    private var activity: MainActivity? = null
    private var container: TestViewGroup? = null

    @Before
    fun setup() {
        postFragment = PostFragment()
        activity = Robolectric.buildActivity(MainActivity::class.java).create().get()
        container = TestViewGroup(activity?.applicationContext)
    }

    /*Checking if OnCreateView inflates PostFragment*/
    @Test
    fun testOnCreateViewReturnsPostFragmentInflate() {
        val actualResult = postFragment?.onCreateView(LayoutInflater.from(activity),
                container, null)
        Assert.assertNotNull(actualResult)
    }

    /*Checking if PostFragment inflates the correct View*/
    @Test
    fun testPostFragmentInflatesWebViewCorrectly() {
        val actualResult = postFragment?.onCreateView(LayoutInflater.from(activity),
                container , null)
        val actualWebView = actualResult?.rootView?.findViewById<WebView>(R.id.webview)
        Assert.assertNotNull(actualWebView)
    }

    @Test
    fun testPostFragmentInflatesWebViewWithTheProperUrl() {
        //Arrange
        val expectedUrl = "https://www.reddit.com/"
        //Act
        val actualResult = postFragment?.onCreateView(LayoutInflater.from(activity),
                container , null)
        val actualWebView = actualResult?.rootView?.findViewById<WebView>(R.id.webview)
        val actulOriginalUrl = actualWebView?.originalUrl
        //Assert
        Assert.assertEquals(expectedUrl, actulOriginalUrl)
    }
}

class TestViewGroup(context: Context?) : ViewGroup(context) {
    override fun onLayout(changed: Boolean, l: Int, t: Int, r: Int, b: Int) {
        //No need in this here.
    }
}
