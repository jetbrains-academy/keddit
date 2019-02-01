package com.edu.keddit

import android.test.ActivityInstrumentationTestCase2
import com.edu.keddit.commons.RxBaseFragment
import com.edu.keddit.features.news.NewsFragment
import org.junit.Assert
import rx.subscriptions.CompositeSubscription


class SolutionAndroidTest : ActivityInstrumentationTestCase2<MainActivity>(MainActivity::class.java) {

    private var mTestActivity: MainActivity? = null
    private var mNewsFragment: RxBaseFragment? = null
    private val field = RxBaseFragment::class.java.getDeclaredField("subscriptions")
    private val methodRequestNews = NewsFragment::class.java.getDeclaredMethod("requestNews")

    @Throws(Exception::class)
    override fun setUp() {
        super.setUp()

        // Starts the activity under test using
        // the default Intent with:
        // action = {@link Intent#ACTION_MAIN}
        // flags = {@link Intent#FLAG_ACTIVITY_NEW_TASK}
        // All other fields are null or empty.
        mTestActivity = activity
        mNewsFragment = mTestActivity!!.supportFragmentManager!!.fragments[0] as RxBaseFragment
        field.isAccessible = true
        methodRequestNews.isAccessible = true
    }

    fun testPreconditions() {
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

//    fun testThereAre10ElementsInTheList() {
//        var actualResult = (mNewsFragment?.adapter as NewsAdapter).itemCount
//        Assert.assertEquals(11, actualResult)
//    }


}