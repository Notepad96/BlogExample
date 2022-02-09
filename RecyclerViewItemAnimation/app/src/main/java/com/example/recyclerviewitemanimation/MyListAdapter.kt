package com.example.recyclerviewitemanimation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.list_item.view.*

class MyListAdapter: RecyclerView.Adapter<MyListAdapter.MyViewHolder>() {

    inner class MyViewHolder(val layout: View): RecyclerView.ViewHolder(layout)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.layout.animation = AnimationUtils.loadAnimation(holder.layout.context, R.anim.list_item_animation)

        holder.layout.text_title.text = "Title ${position+1}"
        holder.layout.text_content.text = "Content ${position+1}"
    }

    override fun getItemCount(): Int {
        return 1000
    }
}