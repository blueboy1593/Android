package com.coukie.bellsmemo.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.room.Room
import com.coukie.bellsmemo.R
import com.coukie.bellsmemo.model.Memo
import com.coukie.bellsmemo.model.room.RoomHelper
import com.coukie.bellsmemo.model.room.RoomMemo
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.list_memo.view.*

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

        buttonSave.setOnClickListener {
            if (editMemo.text.toString().isNotEmpty()){
                val memo = RoomMemo(editMemo.text.toString(), "요기는 컨텐츠")
                helper?.roomMemoDao()?.insert(memo)

                adapter.listData.clear()
                adapter.listData.addAll(helper?.roomMemoDao()?.getAll() ?: mutableListOf())
                adapter.notifyDataSetChanged()
                editMemo.setText("")
            }
        }
    }
}