package com.example.calendar

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val cal = Calendar.getInstance()

        // 달력 로드
        btn_load_calendar.setOnClickListener {
            DatePickerDialog(this, DatePickerDialog.OnDateSetListener { datePicker, y, m, d ->
                text_selected_date.text = "$y/${m+1}/$d"
            }, cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DAY_OF_MONTH)).show()
        }

        // 타이머 로드
        btn_load_timer.setOnClickListener {
            TimePickerDialog(this, TimePickerDialog.OnTimeSetListener { timePicker, h, m ->
                text_selected_time.text = "$h:$m"
            }, cal.get(Calendar.HOUR), cal.get(Calendar.MINUTE), true ).show()
        }

    }
}