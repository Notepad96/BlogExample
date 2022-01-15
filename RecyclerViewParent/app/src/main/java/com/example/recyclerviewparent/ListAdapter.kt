package com.example.recyclerviewparent

import android.app.Activity
import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.list_item.view.*

class ListAdapter: RecyclerView.Adapter<ListAdapter.MyViewHolder>() {
    var colors = listOf("#ff0000", "#00ff00", "#0000ff", "#000000")
    lateinit var parentContext: Context

    inner class MyViewHolder(val layout: View): RecyclerView.ViewHolder(layout)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        parentContext = parent.context
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.layout.list_item_layout.setBackgroundColor(Color.parseColor(colors[position]))

        holder.layout.list_item_layout.setOnClickListener {
            (parentContext as Activity).layout_color.setBackgroundColor(Color.parseColor(colors[position]))
        }
    }

    override fun getItemCount(): Int {
        return colors.size;
    }
}