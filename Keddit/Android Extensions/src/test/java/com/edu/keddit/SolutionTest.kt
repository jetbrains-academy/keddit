package com.edu.keddit

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.edu.keddit.features.news.NewsFragment
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner
import org.robolectric.util.ReflectionHelpers

@RunWith(RobolectricTestRunner::class)
class SolutionTest {
    private var newsFragment: NewsFragment? = null
    private var activity: MainActivity? = null
    private var container: TestViewGroup? = null
    @Before
    fun setup() {
        activity = Robolectric.buildActivity(MainActivity::class.java).create().get()
        newsFragment = activity?.supportFragmentManager!!.fragments[0] as NewsFragment
        container = TestViewGroup(activity?.applicationContext)
        newsFragment?.onCreateView(LayoutInflater.from(activity), container , null)
    }
    @Test
    fun testOnActivityCreatedNewsListNotNull() {
        newsFragment?.onActivityCreated(null)
        val actualResult = ReflectionHelpers.getField<androidx.recyclerview.widget.RecyclerView>(newsFragment, "newsList")
        Assert.assertNotNull(actualResult)
    }
    @Test
    fun testBeforeActivityCreatedHasFixedSizedFalse() {
        val actualResult = ReflectionHelpers.getField<androidx.recyclerview.widget.RecyclerView>(newsFragment, "newsList").hasFixedSize()
        Assert.assertEquals(false, actualResult)
    }
    @Test
    fun testOnActivityCreatedHasFixedSizedBecomesTrue() {
        newsFragment?.onActivityCreated(null)
        val actualResult = ReflectionHelpers.getField<androidx.recyclerview.widget.RecyclerView>(newsFragment, "newsList").hasFixedSize()
        Assert.assertEquals(true, actualResult)
    }
    @Test
    fun testBeforeActivityCreatedLayoutManagerIsNull() {
        val actualResult = ReflectionHelpers.getField<androidx.recyclerview.widget.RecyclerView>(newsFragment, "newsList").layoutManager
        Assert.assertNull(actualResult)
    }
    @Test
    fun testOnActivityCreatedlayoutManagerBecomesNotNull() {
        newsFragment?.onActivityCreated(null)
        val actualResult = ReflectionHelpers.getField<androidx.recyclerview.widget.RecyclerView>(newsFragment, "newsList").layoutManager
        Assert.assertNotNull(actualResult)
    }

}

class TestViewGroup(context: Context?) : ViewGroup(context) {
    override fun onLayout(changed: Boolean, l: Int, t: Int, r: Int, b: Int) {
        //No need in this here.
    }
}
