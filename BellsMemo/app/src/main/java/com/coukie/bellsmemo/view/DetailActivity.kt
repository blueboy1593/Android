package com.coukie.bellsmemo.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.coukie.bellsmemo.R
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        println(this)

        titleMemo.text =intent.getStringExtra("title")
        contentMemo.text =intent.getStringExtra("content")
    }
}