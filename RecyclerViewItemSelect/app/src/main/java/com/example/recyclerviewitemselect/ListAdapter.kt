package com.example.recyclerviewitemselect

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.list_item.view.*

class ListAdapter: RecyclerView.Adapter<ListAdapter.ListView>() {
    var selectPos = -1

    inner class ListView(val layout: View): RecyclerView.ViewHolder(layout)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListView {
        return ListView(LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false))
    }

    override fun onBindViewHolder(holder: ListView, position: Int) {
        if(selectPos == position) {
            holder.layout.list_item_layout.setBackgroundColor(Color.parseColor("#aaaaaa"))
        } else {
            holder.layout.list_item_layout.setBackgroundColor(Color.WHITE)
        }


        holder.layout.list_item_layout.setOnClickListener {
            var beforePos = selectPos
            selectPos = position

            notifyItemChanged(beforePos)
            notifyItemChanged(selectPos)
        }
    }

    override fun getItemCount(): Int {
        return 20
    }
}