package com.coukie.bellsmemo.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.coukie.bellsmemo.R
import com.coukie.bellsmemo.model.Memo
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val memos = ArrayList<Memo>()
        memos.add(Memo("첫 메모", "내용무"))
        memos.add(Memo("두번째 메모", "내용무"))

        val adapter = MemoAdapter(memos)
        println(memos)
        noterecyclerView.adapter = adapter
    }
}