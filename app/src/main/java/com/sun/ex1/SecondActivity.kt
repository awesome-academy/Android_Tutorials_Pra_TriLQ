package com.sun.ex1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        supportActionBar?.title = "Second Activity"

        val messageText: TextView = findViewById(R.id.message)
        val replyButton : Button = findViewById(R.id.button)
        val replyText: EditText = findViewById(R.id.replyText)

        replyButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("reply", replyText.text.toString())
            startActivity(intent)
        }

        messageText.text = intent.getStringExtra("message")
    }
}