package com.sun.exercise

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.sun.exercise.databinding.ActivityMainBinding
import com.sun.exercise.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    private val binding: ActivitySecondBinding by lazy {
        ActivitySecondBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        supportActionBar?.title = getString(R.string.title_second_activity)

        binding.replyButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra(MESSAGE_REPLY_KEY, binding.replyEditText.text.toString())
            startActivity(intent)
        }

        binding.sendTextView.text = intent.getStringExtra(MESSAGE_SEND_KEY)
    }
    companion object{
        const val MESSAGE_SEND_KEY = "send"
        const val MESSAGE_REPLY_KEY = "reply"
    }
}
