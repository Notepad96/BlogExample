package com.example.tipexample

import android.os.Bundle
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {
    var num = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        main_calendar.setOnDateChangeListener { calendarView, y, m, d ->
            val calendar = Calendar.getInstance()
            calendar.set(y, m, d)
            val str = convertString(calendar.time, "work", ++num)

            main_date_text.text = str
        }
    }

    private fun convertString(date: Date, title: String, num: Int): String {
        val format = SimpleDateFormat("yyyyMMdd")
        return "${format.format(date)}_${title}_${num}"
    }
}