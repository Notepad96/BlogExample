package com.example.sharedpreferences

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.edit
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var option: SharedPreferences
    lateinit var userInfo: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        option = getSharedPreferences("option", MODE_PRIVATE)
        userInfo = getSharedPreferences("user_info", MODE_PRIVATE)



        vBtnMoveActivity.setOnClickListener {
            var intent = Intent(this, MainActivity2::class.java)
            startActivity(intent)
        }

        vBtnNameSave.setOnClickListener {
            userInfo.edit {
                putString("name", vEditUserName.text.toString())
                vEditUserName.setText("")
            }
            Toast.makeText(applicationContext, "Name Save!!", Toast.LENGTH_LONG).show()
        }

        vSwitchAlarm.setOnCheckedChangeListener { compoundButton, b ->
            option.edit {
                putBoolean("alarm", vSwitchAlarm.isChecked)
            }
        }
    }

    override fun onStart() {
        saveValueLoad() // Value Load
        super.onStart()
    }

    private fun saveValueLoad() {
        vEditUserName.setText(userInfo.getString("name", ""))

        vSwitchAlarm.isChecked = option.getBoolean("alarm", false)
    }
}