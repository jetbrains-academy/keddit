package com.edu.keddit

import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner

@RunWith(RobolectricTestRunner::class)
class SolutionTest {
    private var activity: MainActivity? = null
    private var manager: androidx.fragment.app.FragmentManager? = null
    @Before
    fun setup() {
        activity = Robolectric.buildActivity(MainActivity::class.java).create().get()
        manager = activity?.supportFragmentManager

    }

    @Test
    fun testManagerIsDeclaredInClearBackStack() {
        val ft = manager?.beginTransaction()
        ft?.addToBackStack(null)
        ft?.commit()
        val listener = TestListener()
        manager?.addOnBackStackChangedListener(listener)
        activity?.clearBackStack()
        Assert.assertTrue("Fragment is not set, check your clearBackStack() method.", listener.modificationCount>0)
    }
}


class TestListener: androidx.fragment.app.FragmentManager.OnBackStackChangedListener {
    var modificationCount = 0
    override fun onBackStackChanged () {
        modificationCount++
    }
}
