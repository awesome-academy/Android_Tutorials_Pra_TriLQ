package com.sun.exercise

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.sun.exercise.databinding.ActivitySongDetailBinding
import com.sun.exercise.placeholder.PlaceholderContent

class SongDetailHostActivity : AppCompatActivity() {

    private val binding: ActivitySongDetailBinding by lazy {
        ActivitySongDetailBinding.inflate(layoutInflater)
    }

    private lateinit var appBarConfiguration: AppBarConfiguration
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        PlaceholderContent.initData(this)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment_song_detail) as NavHostFragment
        val navController = navHostFragment.navController
        appBarConfiguration = AppBarConfiguration(navController.graph)

        setupActionBarWithNavController(navController, appBarConfiguration)
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_song_detail)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }
}
