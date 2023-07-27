package com.sun.exercise

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.sun.exercise.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        supportActionBar?.title = getString(R.string.title_main_activity)

        binding.sendButton.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra(MESSAGE_SEND_KEY, binding.sendEditText.text.toString())
            startActivity(intent)
        }

        binding.replyTextView.text = intent.getStringExtra(MESSAGE_REPLY_KEY)
        if (binding.replyTextView.text != null && binding.replyTextView.text.toString() != ""){
            binding.replyTextHeader.visibility = View.VISIBLE
            binding.replyTextView.visibility = View.VISIBLE
        }
    }
    companion object{
        const val MESSAGE_SEND_KEY = "send"
        const val MESSAGE_REPLY_KEY = "reply"
    }
}
