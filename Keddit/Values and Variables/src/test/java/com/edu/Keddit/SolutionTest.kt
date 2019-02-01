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
    @Before
    fun setup() {
        activity = Robolectric.buildActivity(MainActivity::class.java).create().get()
    }
    @Test
    fun testToolbarIsNotNull() {
        Assert.assertNotNull("Toolbar is not set, check your onCreate() method.", activity?.findViewById(R.id.toolbar))
    }
    @Test
    fun  testSupportActiobnBarIsNotNull(){
        Assert.assertNotNull("SupportActionBar is not set, check your onCreate() method.", activity?.supportActionBar)
    }
}
