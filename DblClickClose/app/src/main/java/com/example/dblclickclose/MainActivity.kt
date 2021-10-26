package com.example.dblclickclose

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    var clickTime: Long = 0
    override fun onBackPressed() {
        var current = System.currentTimeMillis()
        if(current - clickTime >= 3500) {   // 3.5 초
            clickTime = current

            Toast.makeText(applicationContext, "한번 더 클릭 시 종료됩니다", Toast.LENGTH_LONG).show()
            // Toast.LENGTH_SHORT = 2.5 초
            // Toast.LENGTH_LONG = 3.5 초
        } else {
            super.onBackPressed()
        }
    }
}