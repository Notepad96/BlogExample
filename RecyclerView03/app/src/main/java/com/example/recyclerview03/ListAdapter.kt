package com.example.recyclerview03

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager
import kotlinx.android.synthetic.main.list_footer.view.*
import kotlinx.android.synthetic.main.list_item.view.*

class ListAdapter(var list: ArrayList<String>): RecyclerView.Adapter<ListAdapter.ListViewHolder>() {
    val HEADER = 1
    val ITEM = 2
    val FOOTER = 3

    class ListViewHolder(val layout: View): RecyclerView.ViewHolder(layout)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        var view =
            when(viewType) {
                HEADER ->
                    LayoutInflater.from(parent.context).inflate(R.layout.list_header, parent, false)
                FOOTER ->
                    LayoutInflater.from(parent.context).inflate(R.layout.list_footer, parent, false)
                else ->
                    LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
            }

        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        if(position == 0) {
            // HEADER
        } else if(position == list.size + 1) {
            // FOOTER
            holder.layout.layoutListFooter.setOnClickListener {
                list.add("")
                this.notifyDataSetChanged()
            }
        } else {
            // ITEM
            holder.layout.textListTitle.text = "Title $position"
            holder.layout.textListContent.text = "Contents $position"
        }
    }

    override fun getItemCount(): Int {
        return list.size + 2
    }

    override fun getItemViewType(position: Int): Int {
        return if(position == 0) {
            HEADER
        } else if(position == list.size + 1) {
            FOOTER
        } else {
            ITEM
        }
    }
}