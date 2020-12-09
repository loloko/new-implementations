package com.fernando.myprojects.ui

import android.os.Bundle
import android.view.View
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupActionBarWithNavController
import com.fernando.myprojects.R
import com.fernando.myprojects.base.BaseActivity
import com.fernando.myprojects.databinding.ActivityMainBinding

class MainActivity : BaseActivity() {

    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // View Binding
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val navHostFragment = supportFragmentManager.findFragmentById(R.id.main_content) as NavHostFragment
        navController = navHostFragment.findNavController()

        setSupportActionBar(binding.toolbar)

        setupActionBarWithNavController(navController)

        // Show and Hide toolbar for full screen
        navController.addOnDestinationChangedListener { _, destination, _ ->
            when (destination.id) {
                R.id.loginFragment ->
                    binding.toolbar.visibility = View.GONE

                R.id.mainFragment -> {
                    supportActionBar?.setDisplayHomeAsUpEnabled(false)
                    binding.toolbar.visibility = View.VISIBLE
                }
                else ->
                    binding.toolbar.visibility = View.VISIBLE

            }
           
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()
    }
}