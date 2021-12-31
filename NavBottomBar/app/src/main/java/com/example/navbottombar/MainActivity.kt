package com.example.navbottombar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.navbottombar.NavBottom.NavBottomHome
import com.example.navbottombar.NavBottom.NavBottomList
import com.example.navbottombar.NavBottom.NavBottomProfile
import com.example.navbottombar.NavBottom.NavBottomSetting
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction().replace(R.id.layout_nav_bottom, NavBottomHome()).commit()

        nav_main_bottom.setOnItemSelectedListener {
            when(it.itemId) {
                R.id.nav_main_bottom_home -> {
                    supportFragmentManager.beginTransaction().replace(R.id.layout_nav_bottom, NavBottomHome()).commit()
                }
                R.id.nav_main_bottom_list -> {
                    supportFragmentManager.beginTransaction().replace(R.id.layout_nav_bottom, NavBottomList()).commit()
                }
                R.id.nav_main_bottom_profile -> {
                    supportFragmentManager.beginTransaction().replace(R.id.layout_nav_bottom, NavBottomProfile()).commit()
                }
                R.id.nav_main_bottom_setting -> {
                    supportFragmentManager.beginTransaction().replace(R.id.layout_nav_bottom, NavBottomSetting()).commit()
                }
            }

            true
        }
    }


}