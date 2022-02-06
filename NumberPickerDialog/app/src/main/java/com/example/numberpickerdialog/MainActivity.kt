package com.example.numberpickerdialog

import android.app.AlertDialog
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.dialog_num_select.view.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var selectNum = 0

        btn_number_select.setOnClickListener {
            val layout = layoutInflater.inflate(R.layout.dialog_num_select, null)
            val build = AlertDialog.Builder(it.context).apply {
                setView(layout)
            }
            val dialog = build.create()
            dialog.show()

            layout.number_picker.minValue = 1
            layout.number_picker.maxValue = 100
            if(selectNum != 0) layout.number_picker.value = selectNum

            layout.btn_cancel.setOnClickListener {
                dialog.dismiss()
            }
            layout.btn_ok.setOnClickListener {
                selectNum = layout.number_picker.value
                btn_number_select.text = "$selectNum 번"
                dialog.dismiss()
            }

        }
    }

}