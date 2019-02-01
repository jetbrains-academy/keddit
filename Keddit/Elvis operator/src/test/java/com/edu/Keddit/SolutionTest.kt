package com.edu.keddit

import android.support.v4.app.Fragment
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner

@RunWith(RobolectricTestRunner::class)
class SolutionTest {
    private var activity: MainActivity? = null
    @Before
    fun setup() {
        activity = Robolectric.buildActivity(MainActivity::class.java).create().get()
        // Filling up the backStack with smth
        val ft = activity?.supportFragmentManager?.beginTransaction()
        ft?.addToBackStack("test")
        ft?.commit()
    }
    @Test
    fun testClearBackStackIsNotCalledIfCleanStackFalse() {
        val exprectedBackStack = activity?.supportFragmentManager?.getBackStackEntryAt(0)
        activity?.changeFragment(Fragment(), false)
        val actualBackStack = activity?.supportFragmentManager?.getBackStackEntryAt(0)
        Assert.assertEquals("You should not change the cleanStack if it is no null - check you do not reassign it anywhere", exprectedBackStack, actualBackStack)
    }
    @Test
    fun testClearBackStackIsNotCalledIfCleanStackNull() {
        val exprectedBackStack = activity?.supportFragmentManager?.getBackStackEntryAt(0)
        activity?.changeFragment(Fragment(), null)
        val actualBackStack = activity?.supportFragmentManager?.getBackStackEntryAt(0)
        Assert.assertEquals("You should provide the false to the conditional check if the cleanStack is null.",exprectedBackStack, actualBackStack)
    }
    @Test
    fun testClearBackStackIsCalledIfCleanStackTrue() {
        val exprectedBackStack = activity?.supportFragmentManager?.getBackStackEntryAt(0)
        activity?.changeFragment(Fragment(), true)
        val actualBackStack = activity?.supportFragmentManager?.getBackStackEntryAt(0)
        Assert.assertNotEquals("You should not change the cleanStack if it is no null - check you do not reassign it anywhere",exprectedBackStack, actualBackStack)
    }
}
