package com.example.imagefullscreen

import android.app.ActivityOptions
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_image.*

class ImageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_image)

        val img = when(intent.getIntExtra("pos", 1)) {
            1 -> R.drawable.img01
            2 -> R.drawable.img02
            else -> R.drawable.img03
        }
        image_full.setImageResource(img)

        image_full.setOnClickListener {
            supportFinishAfterTransition()
        }
    }
}