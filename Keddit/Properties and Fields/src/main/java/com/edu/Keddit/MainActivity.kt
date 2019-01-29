package com.edu.Keddit

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v7.widget.Toolbar

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
      manager.popBackStack(first.id, FragmentManager.POP_BACK_STACK_INCLUSIVE)
    }
  }

}
