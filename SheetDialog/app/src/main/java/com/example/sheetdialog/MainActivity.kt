package com.example.sheetdialog

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.SeekBar
import com.google.android.material.bottomsheet.BottomSheetDialog
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.sheet_main.view.*

class MainActivity : AppCompatActivity() {
    lateinit var sheetLayout: View
    lateinit var selectButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sheetLayout = LayoutInflater.from(this).inflate(R.layout.sheet_main, null, false)
        var sheetDialog = BottomSheetDialog(this)
        sheetDialog.setContentView(sheetLayout)

        btnOpenSheet.setOnClickListener {
            btnClick(btnOpenSheet)
            sheetDialog.show()
        }

        btnOpenSheet2.setOnClickListener {
            btnClick(btnOpenSheet2)
            sheetDialog.show()
        }
        sheetLayout.seekWidth.setOnSeekBarChangeListener(SeekBarListener())
    }

    private fun btnClick(obj: Button) {
        selectButton = obj
        var temp = obj.width * 100 / layoutMain.width
        sheetLayout.seekWidth.progress = temp
        sheetLayout.textSeekProgress.text = "$temp"
    }

    inner class SeekBarListener: SeekBar.OnSeekBarChangeListener {
        override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
            var temp = p1 * layoutMain.width / 100
            Log.d("test", "$temp")
            selectButton.width = temp
            sheetLayout.textSeekProgress.text = "$p1"
        }

        override fun onStartTrackingTouch(p0: SeekBar?) {

        }

        override fun onStopTrackingTouch(p0: SeekBar?) {
        }
    }
}