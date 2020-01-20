package com.edu.keddit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.appcompat.widget.Toolbar
import androidx.navigation.fragment.NavHostFragment
import com.edu.keddit.features.news.NewsFragment

class MainActivity : AppCompatActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)
    val toolbar = findViewById(R.id.toolbar) as Toolbar
    setSupportActionBar(toolbar)

    val host = NavHostFragment.create(R.navigation.nav_graph)
    supportFragmentManager.beginTransaction().replace(R.id.activity_base_content, host).setPrimaryNavigationFragment(host).commit()
  }

  fun changeFragment(f: Fragment, cleanStack: Boolean = false) {
    val ft = supportFragmentManager.beginTransaction()
    if (cleanStack) {
      clearBackStack()
    }
    ft.setCustomAnimations(
            R.anim.abc_fade_in, R.anim.abc_fade_out, R.anim.abc_popup_enter, R.anim.abc_popup_exit)
    ft.replace(R.id.activity_base_content, f)
    ft.addToBackStack(null)
    ft.commit()
  }

  fun clearBackStack() {
    val manager = supportFragmentManager
    if (manager.backStackEntryCount > 0) {
      val first = manager.getBackStackEntryAt(0)
      manager.popBackStack(first.id, FragmentManager.POP_BACK_STACK_INCLUSIVE)
    }
  }

  /**
   * Finish activity when reaching the last fragment.
   */
  override fun onBackPressed() {
    val fragmentManager = supportFragmentManager
    if (fragmentManager.backStackEntryCount > 1) {
      fragmentManager.popBackStack()
    } else {
      finish()
    }
  }
}