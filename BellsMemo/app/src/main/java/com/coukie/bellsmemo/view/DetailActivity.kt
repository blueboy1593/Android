package com.coukie.bellsmemo.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.coukie.bellsmemo.R
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.android.synthetic.main.activity_detail.titleMemo

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        titleMemo.text =intent.getStringExtra("title")
        contentMemo.text =intent.getStringExtra("content")

        goMain2.setOnClickListener {
            onBackPressed()
        }
    }
}