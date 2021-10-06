package com.example.recyclerview01

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Adapter
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var manager01 = LinearLayoutManager(this)
        var adapter01 = ListAdapterVertical()

        var RecyclerView01 = recyclerVertical.apply {
            adapter = adapter01
            layoutManager = manager01
        }


        var list = arrayListOf("Test 1", "Test 2", "Test 3", "Test 4")
        var manager02 = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        var adapter02 = ListAdapterHorizontal(list)

        var RecyclerView02 = recyclerHorizon.apply {
            adapter = adapter02
            layoutManager = manager02
        }
    }
}