package com.example.menupopup

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var listManager = LinearLayoutManager(this)
        var listAdapter = MyListAdapter()

        vListMain.apply {
            layoutManager = listManager
            adapter = listAdapter
        }
    }
}