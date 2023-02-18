package com.example.calendarcustom

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.list_item_day.view.*
import java.util.*

class AdapterDay(val tempMonth:Int, val dayList: MutableList<Date>): RecyclerView.Adapter<AdapterDay.DayView>() {
    val ROW = 6

    inner class DayView(val layout: View): RecyclerView.ViewHolder(layout)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DayView {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.list_item_day, parent, false)
        return DayView(view)
    }

    override fun onBindViewHolder(holder: DayView, position: Int) {
        holder.layout.item_day_layout.setOnClickListener {
            Toast.makeText(holder.layout.context, "${dayList[position]}", Toast.LENGTH_SHORT).show()
        }
        holder.layout.item_day_text.text = dayList[position].date.toString()

        holder.layout.item_day_text.setTextColor(when(position % 7) {
            0 -> Color.RED
            6 -> Color.BLUE
            else -> Color.BLACK
        })

        if(tempMonth != dayList[position].month) {
            holder.layout.item_day_text.alpha = 0.4f
        }
    }

    override fun getItemCount(): Int {
        return ROW * 7
    }
}