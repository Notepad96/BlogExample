package com.example.styledrawableshape

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textView.setOnClickListener {
            Toast.makeText(this, "TextView Click!", Toast.LENGTH_SHORT).show()
        }
        button.setOnClickListener {
            Toast.makeText(this, "Button Click!", Toast.LENGTH_SHORT).show()
        }
        linearLayout.setOnClickListener {
            Toast.makeText(this, "LinearLayout Click!", Toast.LENGTH_SHORT).show()
        }
    }
}