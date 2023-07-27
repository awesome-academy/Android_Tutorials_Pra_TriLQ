package com.sun.exercise

import android.app.SearchManager
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.sun.exercise.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        supportActionBar?.title = getString(R.string.title_main_activity)

        binding.buttonWebsite.setOnClickListener {
            val intent = Intent(Intent.ACTION_WEB_SEARCH).apply {
                putExtra(SearchManager.QUERY, binding.editTextWebsite.text.toString())
            }
            startActivity(intent)
        }

        binding.buttonLocation.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW).apply {
                val locationQuery: String = QUERY_FORM + binding.editTextLocation.text.toString().replace(" ","+")
                data = Uri.parse(locationQuery)
            }
            startActivity(intent)
        }

        binding.buttonShareSnippet.setOnClickListener {
            val intent = Intent(Intent.ACTION_SEND).apply {
                type = PLAIN_TEXT
                putExtra(Intent.EXTRA_TEXT, binding.editTextShareSnippet.text.toString())
            }
            startActivity(intent)
        }
    }
    companion object{
        private const val QUERY_FORM = "geo:0,0?q="
        private const val PLAIN_TEXT = "text/plain"
    }
}
