package com.edu.keddit

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.get
import androidx.navigation.ui.setupActionBarWithNavController
import com.edu.keddit.features.news.NewsFragment
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

    /*Checking if OnCreateView inflates NewsFragment*/
    @Test
    fun testNavHostContainsPostFragment() {
        val actualNavHost = NavHostFragment.create(R.navigation.nav_graph)
        val test = activity?.findNavController(R.navigation.nav_graph)
//        activity?.setupActionBarWithNavController(actualNavHost.navController)
        val actualPostFragment = actualNavHost.navController.graph.findNode(R.id.postFragment)
        Assert.assertNotNull(actualPostFragment)
    }

}

class TestViewGroup(context: Context?) : ViewGroup(context) {
    override fun onLayout(changed: Boolean, l: Int, t: Int, r: Int, b: Int) {
        //No need in this here.
    }
}
