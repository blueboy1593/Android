package com.coukie.bellsmemo.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.coukie.bellsmemo.R
import kotlinx.android.synthetic.main.activity_detail.*

class WriteMemoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_writememo)
        println(this)
    }
}