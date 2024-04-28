package com.cryptoin.nolancrypto.presentation.main

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.cryptoin.nolancrypto.R
import com.cryptoin.nolancrypto.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val isLogin = false

    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setupBottomNav()
    }

    private fun setupBottomNav() {
        val navController = findNavController(R.id.nav_host_fragment_activity_main)
        binding.navView.setupWithNavController(navController)
        navController.addOnDestinationChangedListener { controller, destination, arguments ->
            when (destination.id) {
                R.id.menu_tab_profile -> {
                    if (!isLogin) {
//                        navigateToLogin()
                        controller.popBackStack(R.id.menu_tab_home, false)
                    }
                }
            }
        }
    }

//    private fun navigateToLogin() {
//        startActivity(Intent(this, LoginActivity::class.java))
//    }

//    fun navigateToTabProfile() {
//        val navController = findNavController(R.id.nav_host_fragment_activity_main)
//        binding.navView.selectedItemId = R.id.menu_tab_profile
//        navController.navigate(R.id.menu_tab_profile)
//    }
}