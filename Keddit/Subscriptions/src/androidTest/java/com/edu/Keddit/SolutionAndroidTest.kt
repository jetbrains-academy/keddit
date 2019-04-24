package com.edu.keddit

import android.support.test.filters.LargeTest
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import com.edu.keddit.commons.RxBaseFragment
import com.edu.keddit.features.news.NewsFragment
import org.junit.Assert
import org.junit.Rule
import org.junit.runner.RunWith
import rx.subscriptions.CompositeSubscription


@RunWith(AndroidJUnit4::class)
@LargeTest
class SolutionAndroidTest {
    @get:Rule
    val activityRule = ActivityTestRule<MainActivity>(MainActivity::class.java)

    private var mTestActivity: MainActivity? = null
    private var mNewsFragment: RxBaseFragment? = null
    private val field = RxBaseFragment::class.java.getDeclaredField("subscriptions")
    private val methodRequestNews = NewsFragment::class.java.getDeclaredMethod("requestNews")


    fun testPreconditions() {
        mTestActivity = activityRule.activity
        mNewsFragment = mTestActivity!!.supportFragmentManager!!.fragments[0] as RxBaseFragment
        field.isAccessible = true
        methodRequestNews.isAccessible = true
        val f = field.get(mNewsFragment)
        Assert.assertNotNull("mTestActivity is null", mTestActivity)
        Assert.assertNotNull("mNewsFragment is null", mNewsFragment)
        Assert.assertNotNull("Subscriptions is null", f)
    }

    fun testNewsFragmentHasSubscriptions() {
        val f: CompositeSubscription = field.get(mNewsFragment) as CompositeSubscription
        Assert.assertTrue(CompositeSubscription::class.java.isInstance(f))
    }

    fun testNewsFragmentHasNoSubscriptionsOnPause() {
        mNewsFragment!!.onPause()
        val f: CompositeSubscription = field.get(mNewsFragment) as CompositeSubscription
        Assert.assertFalse(f.hasSubscriptions())
    }

    fun testNewsFragmentHasNoSubscriptionsOnResume() {
        mNewsFragment!!.onResume()
        val f: CompositeSubscription = field.get(mNewsFragment) as CompositeSubscription
        Assert.assertFalse(f.hasSubscriptions())
    }

    fun testThereisSubscriptionAfterRequestNews() {
        methodRequestNews.invoke(mNewsFragment as NewsFragment)
        val f: CompositeSubscription = field.get(mNewsFragment) as CompositeSubscription
        Assert.assertTrue(f.hasSubscriptions())
    }
}