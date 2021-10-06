package com.example.recyclerview01

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.list_item_vert.view.*

class ListAdapterVertical:  RecyclerView.Adapter<ListAdapterVertical.ListAdapter>(){
    var titles = arrayListOf("Title 1", "Title 2", "Title 3", "Title 4")
    var contents = arrayListOf("Content 1", "Content 2", "Content 3", "Content 4")

    class ListAdapter(val layout: View): RecyclerView.ViewHolder(layout)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListAdapter {
        return ListAdapter(LayoutInflater.from(parent.context).inflate(R.layout.list_item_vert, parent, false))
    }

    override fun onBindViewHolder(holder: ListAdapter, position: Int) {
        holder.layout.textTitle.text = titles[position]

        holder.layout.textContent.text = contents[position]
    }

    override fun getItemCount(): Int {
        return contents.size
    }
}