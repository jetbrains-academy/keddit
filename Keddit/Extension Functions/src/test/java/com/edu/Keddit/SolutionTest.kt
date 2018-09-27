package com.edu.Keddit

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import com.edu.Keddit.features.news.NewsFragment
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner

@RunWith(RobolectricTestRunner::class)
class SolutionTest {
    private var newsFragment: NewsFragment? = null
    private var activity: MainActivity? = null
    private var container: TestViewGroup? = null
    @Before
    fun setup() {
        newsFragment = NewsFragment()
        activity = Robolectric.buildActivity(MainActivity::class.java).create().get()
        container = TestViewGroup(activity?.applicationContext)
    }
    @Test
    fun testOnCreateViewReturnsNewsFragmentInflate() {
        val actualResult = newsFragment?.onCreateView(LayoutInflater.from(activity), container, null)
        Assert.assertNotNull(actualResult)
    }
    @Test
    fun testNewsFragmentInflatesCorrectly() {
        val expectedResult = LayoutInflater.from(activity).inflate(R.layout.news_fragment, null, false)
        val actualResult = newsFragment?.onCreateView(LayoutInflater.from(activity), container , null)
        //We are comparing Ids to avoid fullscale equals() implementation.
        Assert.assertEquals(expectedResult.id, actualResult?.id)
    }
}

class TestViewGroup(context: Context?) : ViewGroup(context) {
    override fun onLayout(changed: Boolean, l: Int, t: Int, r: Int, b: Int) {
        //No need in this here.
    }
}
