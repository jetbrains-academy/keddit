package com.edu.keddit

import android.R
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.navigation.fragment.findNavController
import com.edu.keddit.features.news.PostFragment
import kotlinx.android.synthetic.main.activity_main.*
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner
import com.edu.keddit.features.news.NewsFragment as NewsFragment

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

    /*Checking if OnCreateView inflates PostFragment*/

    @Test
    fun testActionAddedToNavGraph() {
        val actualStartDestination = activity!!
                .nav_host_fragment
                .findNavController()
                .graph
                .startDestination
        val actualNavAction = activity!!
                .nav_host_fragment
                .findNavController()
                .graph
                .findNode(actualStartDestination)
                ?.getAction(com.edu.keddit.R.id.action_newsFragment_to_postFragment)
        Assert.assertNotNull(actualNavAction)
    }

    @Test
    fun testActionAddedNewsFragment() {
        val view = newsFragment?.onCreateView(LayoutInflater.from(activity),
                container , null)
        newsFragment?.onViewCreated(view!!, null)
        val hasListener = view?.hasOnClickListeners()
        Assert.assertNotNull(hasListener)
    }


}

class TestViewGroup(context: Context?) : ViewGroup(context) {
    override fun onLayout(changed: Boolean, l: Int, t: Int, r: Int, b: Int) {
        //No need in this here.
    }
}
