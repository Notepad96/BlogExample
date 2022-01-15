package com.example.menucontext

import android.os.Bundle
import android.view.ContextMenu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        registerForContextMenu(vTextMenuItem)
    }

    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        super.onCreateContextMenu(menu, v, menuInfo)
        menuInflater.inflate(R.menu.context_menu, menu)
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        vTextMenuItem.text = item.toString()
        var text = when(item.itemId) {
            R.id.item1 -> "Item1 Click"
            R.id.item2 -> "Item2 Click"
            R.id.item21 -> "Item21 Click"
            R.id.item22 -> "Item22 Click"
            else -> "Item3 Click"
        }
        Toast.makeText(applicationContext, text, Toast.LENGTH_LONG).show()
        return super.onContextItemSelected(item)
    }
}