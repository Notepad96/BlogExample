package com.example.chipsexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        chipGroup.setOnCheckedChangeListener { group, checkedId ->
            when(checkedId) {
                R.id.chip01 -> {
                    Toast.makeText(applicationContext, "chip01", Toast.LENGTH_SHORT).show()
                }
                R.id.chip02 -> {
                    Toast.makeText(applicationContext, "chip02", Toast.LENGTH_SHORT).show()
                }
                R.id.chip03 -> {
                    Toast.makeText(applicationContext, "chip03", Toast.LENGTH_SHORT).show()
                }
                else -> {
                    Toast.makeText(applicationContext, "Nothing", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}