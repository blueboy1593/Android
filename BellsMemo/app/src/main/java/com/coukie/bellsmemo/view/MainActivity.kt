package com.coukie.bellsmemo.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.coukie.bellsmemo.R
import com.coukie.bellsmemo.model.room.RoomMemo
import com.coukie.bellsmemo.presenter.MemoHelper
import com.coukie.bellsmemo.presenter.MemoPresenter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val presenter = MemoPresenter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val helper = MemoHelper(this)

        val adapter = MemoAdapter()
        adapter.helper = helper

        adapter.listData.addAll(helper?.roomMemoDao()?.getAll() ?: mutableListOf())
        noterecyclerView.adapter = adapter

        presenter.intentWriteMemoActivity(writeMemo, WriteMemoActivity::class.java)

        searchButton.setOnClickListener {
            val searchItem = searchText.text
            val searchData = mutableListOf<RoomMemo>()
            adapter.listData.forEach {
                if (it.title.contains(searchItem) or it.content.contains(searchItem)) {
                    searchData.add(it)
                }
            }
            adapter.listData = searchData
            noterecyclerView.adapter = adapter
        }

        goHome.setOnClickListener {
            finishAffinity()
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}