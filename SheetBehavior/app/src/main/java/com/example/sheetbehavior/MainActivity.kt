package com.example.sheetbehavior

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomsheet.BottomSheetBehavior
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.sheet_main.view.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var behavior = BottomSheetBehavior.from(bottomSheet)
        layoutDialog.seekWidth.progress = 50
        layoutDialog.textSeekProgress.text = "50"
        behavior.state = BottomSheetBehavior.STATE_HIDDEN

        btnOpenSheet.setOnClickListener {
            behavior.state = BottomSheetBehavior.STATE_COLLAPSED
        }

        layoutMain.setOnClickListener {
            behavior.state = BottomSheetBehavior.STATE_HIDDEN
        }
    }
//    STATE_COLLAPSED : peekHeight 만큼
//    STATE_EXPANDED : 가득
//    STATE_HIDDEN : 숨김

}