import android.support.test.filters.LargeTest
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import android.support.v7.widget.RecyclerView
import com.edu.keddit.MainActivity

import com.edu.keddit.api.adapter.test.NewsAdapter
import kotlinx.android.synthetic.main.news_fragment.*
import org.junit.Assert
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@LargeTest
class SolutionAndroidTest {
    @get:Rule
    val activityRule = ActivityTestRule<MainActivity>(MainActivity::class.java)

    private var mTestActivity: MainActivity? = null
    private var mNewsFragment: RecyclerView? = null


    @Test
    fun testPreconditions() {
        mTestActivity = activityRule.activity
        mNewsFragment = mTestActivity!!.news_list
        Assert.assertNotNull("mTestActivity is null", mTestActivity)
        Assert.assertNotNull("mTestEmptyText is null", mNewsFragment)
    }

    @Test
    fun testThereAre10ElementsInTheList() {
        mTestActivity = activityRule.activity
        mNewsFragment = mTestActivity!!.news_list
        var actualResult = (mNewsFragment?.adapter as NewsAdapter).itemCount
        Assert.assertEquals(10, actualResult)
    }


}