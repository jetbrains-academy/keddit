package com.edu.keddit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentManager
import androidx.appcompat.widget.Toolbar

class MainActivity : AppCompatActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)
    val toolbar = findViewById(R.id.toolbar) as Toolbar
    setSupportActionBar(toolbar)
  }

  fun clearBackStack() {
    val manager = supportFragmentManager
    if (manager.backStackEntryCount > 0) {
      val first = manager.getBackStackEntryAt(0)
      manager.popBackStack(first.id, androidx.fragment.app.FragmentManager.POP_BACK_STACK_INCLUSIVE)
    }
  }

}
