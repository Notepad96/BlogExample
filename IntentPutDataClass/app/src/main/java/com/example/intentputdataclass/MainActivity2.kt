package com.example.intentputdataclass

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main2.*

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        if(intent.getIntExtra("type", 0) == 0) {
            var user = intent.getParcelableExtra<User>("user1")
            txtGetData.text = user.toString()
        } else {
            var users = intent.getSerializableExtra("users") as ArrayList<User>
            var text = ""
            for(user in users) {
                text += "$user\n"
            }
            txtGetData.text = text
        }
    }
}