package com.coukie.bellsmemo.view

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.coukie.bellsmemo.R
import com.coukie.bellsmemo.model.room.RoomMemo
import com.coukie.bellsmemo.presenter.MemoHelper
import com.coukie.bellsmemo.presenter.MemoPresenter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_writememo.*

class WriteMemoActivity : AppCompatActivity() {

    private val presenter = MemoPresenter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_writememo)

        goMain.setOnClickListener {
            onBackPressed()
        }

        val helper = MemoHelper(this)

        addNoteIv.setOnClickListener {
            if (titleEt.text.toString().isNotEmpty() and contentEt.text.toString().isNotEmpty()){
                val memo = RoomMemo(titleEt.text.toString(), contentEt.text.toString())
                helper?.roomMemoDao()?.insert(memo)

                presenter.intentMainActivity(it, MainActivity())
            }
        }
    }
}