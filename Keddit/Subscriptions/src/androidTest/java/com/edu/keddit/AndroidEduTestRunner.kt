package com.edu.keddit

import androidx.test.runner.AndroidJUnitRunner

class AndroidEduTestRunner : AndroidJUnitRunner() {
    override fun sendStatus(resultCode: Int, results: android.os.Bundle) {
        if (resultCode < 0) {
            val stack = results.getString("stack")
            if (stack != null) {
                val errorMessage = stack.substringAfter(":").trim().substringBefore("\n")
                results.putString("stack", "#educational_plugin FAILED + $errorMessage")
            }
        }
        super.sendStatus(resultCode, results)
    }
}

