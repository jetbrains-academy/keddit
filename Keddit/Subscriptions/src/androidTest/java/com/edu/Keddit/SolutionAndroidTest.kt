import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import androidx.test.runner.AndroidJUnit4
import com.edu.keddit.MainActivity

import com.edu.keddit.commons.RxBaseFragment
import com.edu.keddit.features.news.NewsFragment
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
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

    @Before
    fun setUp() {
        //Revealing tested entities
        field.isAccessible = true
        methodRequestNews.isAccessible = true
    }

    @Test
    fun testPreconditions() {
        //Arrange
        mTestActivity = activityRule.activity
        mNewsFragment = mTestActivity!!.supportFragmentManager!!.fragments[0] as RxBaseFragment
        val f = field.get(mNewsFragment)
        //Assert
        Assert.assertNotNull("mTestActivity is null", mTestActivity)
        Assert.assertNotNull("mNewsFragment is null", mNewsFragment)
        Assert.assertNotNull("Subscriptions is null", f)
    }

    @Test
    fun testNewsFragmentHasSubscriptions() {
        //Arrange
        mTestActivity = activityRule.activity
        mNewsFragment = mTestActivity!!.supportFragmentManager!!.fragments[0] as RxBaseFragment
        val f: CompositeSubscription = field.get(mNewsFragment) as CompositeSubscription
        //Assert
        Assert.assertTrue(CompositeSubscription::class.java.isInstance(f))
    }

    @Test
    fun testNewsFragmentHasNoSubscriptionsOnPause() {
        //Arrange
        mTestActivity = activityRule.activity
        mNewsFragment = mTestActivity!!.supportFragmentManager!!.fragments[0] as RxBaseFragment
        mNewsFragment!!.onPause()
        val f: CompositeSubscription = field.get(mNewsFragment) as CompositeSubscription
        //Assert
        Assert.assertFalse(f.hasSubscriptions())
    }

    @Test
    fun testNewsFragmentHasNoSubscriptionsOnResume() {
        //Arrange
        mTestActivity = activityRule.activity
        mNewsFragment = mTestActivity!!.supportFragmentManager!!.fragments[0] as RxBaseFragment
        mNewsFragment!!.onResume()
        val f: CompositeSubscription = field.get(mNewsFragment) as CompositeSubscription
        //Assert
        Assert.assertFalse(f.hasSubscriptions())
    }

    @Test
    fun testThereIsSubscriptionAfterRequestNews() {
        //Arrange
        mTestActivity = activityRule.activity
        mNewsFragment = mTestActivity!!.supportFragmentManager!!.fragments[0] as RxBaseFragment
        methodRequestNews.invoke(mNewsFragment as NewsFragment)
        val f: CompositeSubscription = field.get(mNewsFragment) as CompositeSubscription
        //Assert
        Assert.assertTrue(f.hasSubscriptions())
    }

}