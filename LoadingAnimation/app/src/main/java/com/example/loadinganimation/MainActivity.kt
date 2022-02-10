package com.example.loadinganimation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val listManager = LinearLayoutManager(this)
        val listAdapter = MyListAdapter()

        // 로딩 창 보여주기
        contentLoading.show()

        Handler().postDelayed(Runnable {
            recycler.apply {
                layoutManager = listManager
                adapter = listAdapter
            }
            contentLoading.hide()   // 로딩 창 감추기
        }, 4000)    // Delay 4초

    }
}