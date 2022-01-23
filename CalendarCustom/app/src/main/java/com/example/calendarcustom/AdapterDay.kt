package com.example.calendarcustom

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import java.util.*

class AdapterDay: RecyclerView.Adapter<AdapterDay.DayView>() {

    inner class DayView(val layout: View): RecyclerView.ViewHolder(layout)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DayView {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: DayView, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }
}