package com.example.snackbar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn = findViewById<Button>(R.id.eventBtn)
        btn.setOnClickListener {
            val layout = findViewById<View>(R.id.mainLayout)
            val snack = Snackbar.make(layout, "SnackBar Open!", Snackbar.LENGTH_SHORT)
                snack.setAction("확 인!", View.OnClickListener {
                    snack.dismiss()
                })
                snack.show()
        }
    }
}