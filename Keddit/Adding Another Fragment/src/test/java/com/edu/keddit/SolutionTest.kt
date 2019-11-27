package com.edu.keddit

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
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

    /*Checking if OnCreateView inflates NewsFragment*/
    @Test
    fun testOnCreateViewReturnsPostFragmentInflate() {
        val actualResult = postFragment?.onCreateView(LayoutInflater.from(activity),
                container, null)
        Assert.assertNotNull(actualResult)
    }

    /*Checking if NewsFragment inflates the correct View*/
    @Test
    fun testPostFragmentInflatesCorrectly() {
        val expectedResult = LayoutInflater.from(activity).inflate(R.layout.news_fragment,
                null, false)
        val actualResult = postFragment?.onCreateView(LayoutInflater.from(activity),
                container , null)
        //We are comparing Ids to avoid full scale equals() implementation.
        Assert.assertEquals(expectedResult.id, actualResult?.id)
    }
}

class TestViewGroup(context: Context?) : ViewGroup(context) {
    override fun onLayout(changed: Boolean, l: Int, t: Int, r: Int, b: Int) {
        //No need in this here.
    }
}
