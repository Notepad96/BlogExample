package com.example.recyclerview02

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.list_grid_item.view.*

class ListAdapterGrid(var list: ArrayList<String>): RecyclerView.Adapter<ListAdapterGrid.GridAdapter>() {

    class GridAdapter(val layout: View): RecyclerView.ViewHolder(layout)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GridAdapter {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.list_grid_item, parent, false)

        return GridAdapter(view)
    }

    override fun onBindViewHolder(holder: GridAdapter, position: Int) {
        holder.layout.textListTitle.text = list[position]
        
        holder.layout.layoutListItem.setOnClickListener {
            Toast.makeText(holder.layout.context, "${list[position]} Click!", Toast.LENGTH_SHORT).show()
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }
}