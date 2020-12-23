package com.coukie.bellsmemo.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import com.coukie.bellsmemo.R
import com.coukie.bellsmemo.model.Memo
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.list_memo.view.*

class MainActivity : AppCompatActivity() {

    var writeMemoButton: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val memos = ArrayList<Memo>()
        memos.add(Memo("첫 메모", "내용무"))
        memos.add(Memo("두번째 메모", "내용무"))

        val adapter = MemoAdapter(memos)
        println(memos)
        noterecyclerView.adapter = adapter

        writeMemoButton = findViewById<View>(R.id.writeMemo) as Button
        writeMemoButton!!.setOnClickListener {
            val intent = Intent(this, WriteMemoActivity::class.java)
            startActivity(intent)
//            println("button")
        }
    }
}