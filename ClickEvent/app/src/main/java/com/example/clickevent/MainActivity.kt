package com.example.clickevent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn01.setOnClickListener{
            Toast.makeText(this, "Btn1 Click!", Toast.LENGTH_SHORT).show()
        }

        btn02.setOnClickListener(clickListner)
    }

    val clickListner = View.OnClickListener { view ->
//        when(view.id)
        Toast.makeText(view.context, "Btn2 Click!", Toast.LENGTH_SHORT).show()
    }


    fun btn03click(view: View) {
        Toast.makeText(view.context, "Btn3 Click!", Toast.LENGTH_SHORT).show()
    }


}