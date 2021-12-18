package com.example.buttonstylecode

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.view.ContextThemeWrapper
import com.google.android.material.button.MaterialButton
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var num = 0

        vBtnAddDefault.setOnClickListener {
            var btn = Button(applicationContext)
            btn.text = "Button ${++num}"
            vLayoutAddBtn.addView(btn)
        }

        vBtnAddCustom.setOnClickListener {
            var newStyle = ContextThemeWrapper(this, R.style.Button_Border)
            var btn = MaterialButton(newStyle)
            btn.text = "Button ${++num}"
            vLayoutAddBtn.addView(btn)
        }
    }
}