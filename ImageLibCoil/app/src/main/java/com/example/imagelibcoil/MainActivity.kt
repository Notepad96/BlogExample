package com.example.imagelibcoil

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import coil.load
import coil.transform.CircleCropTransformation
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        img_test01.load(R.drawable.img01) {
            transformations(CircleCropTransformation())
        }
    }
}