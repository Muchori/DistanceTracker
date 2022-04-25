package com.muchori.joseph.distancetracker.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.muchori.joseph.distancetracker.R
import com.muchori.joseph.distancetracker.util.Permissions.hasLocationPermission

class MainActivity : AppCompatActivity() {

  private lateinit var navController: NavController

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    //navController = findNavController(R.id.navHostFragment)
    val navHostFragment = supportFragmentManager
      .findFragmentById(R.id.navHostFragment) as NavHostFragment
    navController = navHostFragment.navController

    if (hasLocationPermission(this)) {
      navController.navigate(R.id.action_permissionFragment_to_mapsFragment)
    }
  }
}