package com.example.farmatodoanime.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.farmatodoanime.R
import com.example.farmatodoanime.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.HiltAndroidApp

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navController = findNavController(R.id.nav_host_fragment_content_main)

        val bottomNavView = binding.bottomAppBar
        bottomNavView.setupWithNavController(navController)

        bottomNavView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.action_home -> {
                    navController.navigate(R.id.fragment_home)
                    true
                }
                R.id.action_search -> {
                    navController.navigate(R.id.fragment_search)
                    true
                }
                else -> false
            }
        }
    }
}