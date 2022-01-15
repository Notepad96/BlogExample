package com.example.recyclerviewsnap

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.PagerSnapHelper
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val listManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        val listAdapter = ListAdapter()
        val snap = PagerSnapHelper()
        snap.attachToRecyclerView(recycler)

        recycler.apply {
            layoutManager = listManager
            adapter = listAdapter
        }
//        recycler.scrollToPosition(2)
    }
}