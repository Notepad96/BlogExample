package com.example.tipexample

import android.os.Bundle
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textView01 = TextView(this)
        val width01 = resources.displayMetrics.widthPixels / 4
        textView01.layoutParams = LinearLayout.LayoutParams(width01, LinearLayout.LayoutParams.WRAP_CONTENT)
        textView01.text = "Text 1"
        textView01.setBackgroundResource(R.color.purple_200)

        val textView02 = TextView(this)
        val width02 = resources.displayMetrics.widthPixels / 4 * 3
        textView02.layoutParams = LinearLayout.LayoutParams(width02, LinearLayout.LayoutParams.WRAP_CONTENT)
        textView02.text = "Text 2"
        textView02.setBackgroundResource(R.color.teal_200)

        linearLayout.addView(textView01)
        linearLayout.addView(textView02)
    }
}