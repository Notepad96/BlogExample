package com.example.menupopup

import android.view.LayoutInflater
import android.view.MenuInflater
import android.view.View
import android.view.ViewGroup
import android.widget.PopupMenu
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.mylist_item.view.*

class MyListAdapter: RecyclerView.Adapter<MyListAdapter.MyView>() {
    private val testTitleList = listOf("Title 1", "Title 2", "Title 3", "Title 4", "Title 5" )
    private val testContentList = listOf("Content 1", "Content 2", "Content 3", "Content 4", "Content 5")

    inner class MyView(val layout: View): RecyclerView.ViewHolder(layout)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyView {
        return MyView(LayoutInflater.from(parent.context).inflate(R.layout.mylist_item, parent, false))
    }

    override fun onBindViewHolder(holder: MyView, position: Int) {
        holder.layout.vTextMyListTitle.text = testTitleList[position]
        holder.layout.vTextMyListContent.text = testContentList[position]

        holder.layout.vLayoutMyListItem.setOnClickListener {
            val popup = PopupMenu(holder.layout.context, it)
            popup.menuInflater.inflate(R.menu.list_item_popup, popup.menu)
            popup.setOnMenuItemClickListener {
                var text = when(it.itemId) {
                    R.id.mItem01 -> "${position+1}번 째 속성 Click"
                    R.id.mItem02 -> "${position+1}번 째 수정 Click"
                    else -> "${position+1}번 째 삭제 Click"
                }
                Toast.makeText(holder.layout.context, text, Toast.LENGTH_LONG).show()
                true
            }
            popup.show()
        }
    }

    override fun getItemCount(): Int {
        return testTitleList.size
    }
}