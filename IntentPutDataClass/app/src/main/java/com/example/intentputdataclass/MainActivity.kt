package com.example.intentputdataclass

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnData.setOnClickListener {
            var intent = Intent(applicationContext, MainActivity2::class.java)
            intent.putExtra("user1", User("Kim", 22, "Teacher"))
            intent.putExtra("type", 0)
            startActivity(intent)
        }

        btnDataList.setOnClickListener {
            var intent = Intent(applicationContext, MainActivity2::class.java)
            var users = arrayListOf<User>()
            users.add(User("Kim", 22, "Teacher"))
            users.add(User("Lee", 26, "Student"))
            users.add(User("Park", 29, "Digimon"))

            intent.putExtra("type", 1)
            intent.putParcelableArrayListExtra("users", users)
            startActivity(intent)
        }
    }
}