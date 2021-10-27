package com.example.apiloadretrofit

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.apiloadretrofit.data.Item
import kotlinx.android.synthetic.main.list_item.view.*
import java.text.DecimalFormat

class ListAdapter(val items: List<Item>): RecyclerView.Adapter<ListAdapter.MyAdapter>() {

    var dec = DecimalFormat("#,###")

    class MyAdapter(val layout: View): RecyclerView.ViewHolder(layout)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyAdapter {

        return MyAdapter(LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false))
    }

    override fun onBindViewHolder(holder: MyAdapter, position: Int) {
        holder.layout.txtSkuName.text = items[position].armSkuName
        holder.layout.txtSkuPrice.text = (dec.format(items[position].retailPrice)).toString() + " 원"
    }

    override fun getItemCount(): Int {
        return items.size
    }
}