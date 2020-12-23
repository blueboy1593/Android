package com.coukie.bellsmemo.view

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.room.Room
import com.coukie.bellsmemo.R
import com.coukie.bellsmemo.model.room.RoomHelper
import com.coukie.bellsmemo.model.room.RoomMemo
import kotlinx.android.synthetic.main.activity_writememo.*

class WriteMemoActivity : AppCompatActivity() {
    var helper: RoomHelper? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_writememo)

        goMain.setOnClickListener {
            onBackPressed()
        }

        // 나중에 따로 빼자
        helper = Room.databaseBuilder(this, RoomHelper::class.java, "room_memo")
            .allowMainThreadQueries()
            .build()

        addNoteIv.setOnClickListener {
            if (titleEt.text.toString().isNotEmpty() and contentEt.text.toString().isNotEmpty()){
                val memo = RoomMemo(titleEt.text.toString(), contentEt.text.toString())
                helper?.roomMemoDao()?.insert(memo)

                // 이거 좀 더 쉽게 할 수 있을거같은데
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }
        }
    }
}