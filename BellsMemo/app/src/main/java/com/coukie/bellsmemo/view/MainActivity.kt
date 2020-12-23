package com.coukie.bellsmemo.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.room.Room
import com.coukie.bellsmemo.R
import com.coukie.bellsmemo.model.room.RoomHelper
import com.coukie.bellsmemo.model.room.RoomMemo
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var helper: RoomHelper? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        helper = Room.databaseBuilder(this, RoomHelper::class.java, "room_memo")
            .allowMainThreadQueries()
            .build()
        val adapter = MemoAdapter()
        adapter.helper = helper

        adapter.listData.addAll(helper?.roomMemoDao()?.getAll() ?: mutableListOf())
        noterecyclerView.adapter = adapter

        writeMemo.setOnClickListener {
            val intent = Intent(this, WriteMemoActivity::class.java)
            startActivity(intent)
        }
    }
}