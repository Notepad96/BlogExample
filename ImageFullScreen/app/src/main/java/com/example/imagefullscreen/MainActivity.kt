package com.example.imagefullscreen

import android.app.ActivityOptions
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        main_image01.setOnClickListener { clickEvent(it,1) }
        main_image02.setOnClickListener { clickEvent(it,2) }
        main_image03.setOnClickListener { clickEvent(it,3) }
    }

    private fun clickEvent(view: View, pos: Int) {
        val intent = Intent(this, ImageActivity::class.java)
        intent.putExtra("pos", pos)
        val opt = ActivityOptions.makeSceneTransitionAnimation(this, view, "imgTrans")
        startActivity(intent, opt.toBundle())
    }

}