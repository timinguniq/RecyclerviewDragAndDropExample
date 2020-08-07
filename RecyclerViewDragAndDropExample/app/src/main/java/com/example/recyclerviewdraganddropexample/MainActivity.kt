package com.example.recyclerviewdraganddropexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), OnStartDragListener {
    lateinit var adapter: RecyclerviewAdapter
    lateinit var touchHelper: ItemTouchHelper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        adapter = RecyclerviewAdapter(this)
        populateListItem()
        val callback: ItemTouchHelper.Callback = ItemMoveCallbackListener(adapter)
        touchHelper = ItemTouchHelper(callback)
        touchHelper.attachToRecyclerView(recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter
    }
    override fun onStartDrag(viewHolder: RecyclerView.ViewHolder) {
        touchHelper.startDrag(viewHolder)
    }
    private fun populateListItem() {
        val users = listOf(
            "도",
            "움",
            "이",
            "되",
            "셨",
            "으",
            "면",
            "깃",
            "허",
            "브",
            "에",
            "별",
            "좀",
            "부",
            "탁",
            "드",
            "립",
            "니",
            "다"
        )
        adapter.setUsers(users)
    }
}