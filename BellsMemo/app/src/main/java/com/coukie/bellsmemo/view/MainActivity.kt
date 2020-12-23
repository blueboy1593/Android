package com.coukie.bellsmemo.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.coukie.bellsmemo.R
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
    }
}