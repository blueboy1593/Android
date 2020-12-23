package com.coukie.bellsmemo.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.coukie.bellsmemo.R
import com.coukie.bellsmemo.model.room.RoomMemo
import com.coukie.bellsmemo.presenter.MemoHelper
import com.coukie.bellsmemo.presenter.MemoPresenter
import kotlinx.android.synthetic.main.activity_update.*
import kotlinx.android.synthetic.main.activity_writememo.addNoteIv
import kotlinx.android.synthetic.main.activity_writememo.goMain

class UpdateActivity : AppCompatActivity() {

    private val presenter = MemoPresenter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update)

        titleEt.setText(intent.getStringExtra("title"))
        contentEt.setText(intent.getStringExtra("content"))
//        contentMemo.text = intent.getStringExtra("content")
        var num = intent.getStringExtra("no")

        goMain.setOnClickListener {
            onBackPressed()
        }

        val helper = MemoHelper(this)

        addNoteIv.setOnClickListener {
            if (titleEt.text.toString().isNotEmpty() and contentEt.text.toString().isNotEmpty()){
                val memo = RoomMemo(titleEt.text.toString(), contentEt.text.toString())
                println(num)
                println(memo.no)
                memo.no = num?.toLong()
                println(memo.no)
                helper?.roomMemoDao()?.update(memo)

                presenter.intentMainActivity(it, MainActivity())
            }
        }
    }
}