import android.support.v7.widget.RecyclerView
import com.edu.keddit.MainActivity
import android.test.ActivityInstrumentationTestCase2
import com.edu.keddit.api.adapter.test.NewsAdapter
import kotlinx.android.synthetic.main.news_fragment.*
import org.junit.Assert


class SolutionAndroidTest : ActivityInstrumentationTestCase2<MainActivity>(MainActivity::class.java) {

    private var mTestActivity: MainActivity? = null
    private var mNewsFragment: RecyclerView? = null

    @Throws(Exception::class)
    override fun setUp() {
        super.setUp()

        // Starts the activity under test using
        // the default Intent with:
        // action = {@link Intent#ACTION_MAIN}
        // flags = {@link Intent#FLAG_ACTIVITY_NEW_TASK}
        // All other fields are null or empty.
        mTestActivity = activity
        mNewsFragment = mTestActivity!!.news_list
    }

    /**
     * Test if your test fixture has been set up correctly.
     * You should always implement a test that
     * checks the correct setup of your test fixture.
     * If this tests fails all other tests are
     * likely to fail as well.
     */
    fun testPreconditions() {
        // Try to add a message to add context to your assertions.
        // These messages will be shown if
        // a tests fails and make it easy to
        // understand why a test failed
        Assert.assertNotNull("mTestActivity is null", mTestActivity)
        Assert.assertNotNull("mTestEmptyText is null", mNewsFragment)
    }

    fun testThereAre10ElementsInTheList() {
        var actualResult = (mNewsFragment?.adapter as NewsAdapter).itemCount
        Assert.assertEquals(11, actualResult)
    }


}