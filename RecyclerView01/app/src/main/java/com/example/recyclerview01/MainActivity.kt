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

    }
}