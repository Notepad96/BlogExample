package com.example.intentputdata

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnOpenLayout.setOnClickListener {
            val intent = Intent(applicationContext, MainActivity2::class.java)
            intent.putExtra("name", "Lee")
            intent.putExtra("age", 32)
            startActivity(intent)
        }
    }
}