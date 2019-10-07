package com.edu.keddit

import org.junit.Assert
import org.junit.Test
import java.lang.Error

class SolutionTest {
    @Test
    fun testSolution() {
        //Arrange
        var actual_error: Error? = null
        //Act
        //TODO: implement tests
        try {
            val actual  = MainActivity()
        }
        catch (e: Error) {
            actual_error = e
        }
        //Assert
        Assert.assertNull("", actual_error)
    }
}
