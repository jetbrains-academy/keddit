package com.edu.keddit

import android.os.Bundle
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner

@RunWith(RobolectricTestRunner::class)
class SolutionTest {
    private var activity: MainActivity? = null
    private var mainActivityClass: Class<MainActivity> =  MainActivity::class.java
    private var parameters: Class<Bundle> =  Bundle::class.java
    @Before
    fun setup() {
        activity = Robolectric.buildActivity(MainActivity::class.java).get()
    }
    @Test
    fun testOnCreateInvokes() {
        var error: String? = null
        try {
            mainActivityClass.getDeclaredMethod("onCreate", parameters )
        }
        catch (e: NoSuchMethodException) {
            error = e.message
        }
        Assert.assertNull("There were problems invoking onCreate() method, check its declaration", error)
    }
    @Test
    fun testOnCreateAcceptsNull() {

        var error: String? = null
        try {
            var onCreateMethod = mainActivityClass.getDeclaredMethod("onCreate", parameters )
            onCreateMethod.isAccessible = true
            onCreateMethod.invoke(activity, null)
        }
        catch (e: IllegalArgumentException) {
            error = e.message
        }
        Assert.assertNull("There were problems invoking onCreate() method, check it accepts \"Bundle?\" as a parameter", error)

    }
}
