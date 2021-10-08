package com.example.recyclerview03

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class ListAdapter(var list: ArrayList<String>): RecyclerView.Adapter<ListAdapter.ListViewHolder>() {

    class ListViewHolder(val layout: View): RecyclerView.ViewHolder(layout)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        var view =
            LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)

        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {

    }

    override fun getItemCount(): Int {
        return list.size + 3
    }

    override fun getItemViewType(position: Int): Int {
        return super.getItemViewType(position)
    }
}