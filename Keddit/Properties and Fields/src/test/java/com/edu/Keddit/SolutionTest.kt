package com.edu.Keddit

import kotlinx.android.synthetic.main.activity_main.view.*
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
    }
    @Test
    fun testManagerNotDeclaredByDefault() {
        Assert.assertNull("Toolbar is not set, check your onCreate() method.", activity?.globalManager)
    }
    @Test
    fun testManagerIsDeclaredInClearBackStack() {
        activity?.clearBackStack()
        Assert.assertNotNull("Fragment is not set, check your clearBackStack() method.", activity?.globalManager)
    }
}
