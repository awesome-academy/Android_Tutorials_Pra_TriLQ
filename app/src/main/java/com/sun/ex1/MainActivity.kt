package com.sun.ex1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.title = "Main Activity"

        val sendButton : Button = findViewById(R.id.button)
        val sendText: EditText = findViewById(R.id.sendText)
        val reply: TextView = findViewById(R.id.reply)
        val replyHeader: TextView = findViewById(R.id.replyHeader)

        sendButton.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra("message", sendText.text.toString())
            startActivity(intent)
        }

        reply.text = intent.getStringExtra("reply")
        if (reply.text != null && reply.text.toString() != ""){
            replyHeader.visibility = View.VISIBLE
            reply.visibility = View.VISIBLE
        }
    }
}