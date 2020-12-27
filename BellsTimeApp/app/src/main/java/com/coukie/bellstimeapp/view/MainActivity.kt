package com.coukie.bellstimeapp.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.coukie.bellstimeapp.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnStopwatch.setOnClickListener {
            supportFragmentManager.beginTransaction()
                .replace(R.id.view, StopwatchFragment())
                .commit()
        }
        btnTimer.setOnClickListener {
            supportFragmentManager.beginTransaction()
                .replace(R.id.view, TimerFragment())
                .commit()
        }

    }
}