package com.coukie.bellstimeapp.view

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.os.Message
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.coukie.bellstimeapp.R
import kotlinx.android.synthetic.main.timer_fragment.*
import java.util.*

class TimerFragment : Fragment() {

    private var isRunning = false
    private var timerTask: Timer? = null
    private var index :Int = 1

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.timer_fragment, container, false)
    }

    override fun onResume() {
        super.onResume()
        floatingActionButton5.setOnClickListener {
            start()
        }

        floatingActionButton6.setOnClickListener {
            pause()
        }

        floatingActionButton7.setOnClickListener {
            reset()
        }

        floatingActionButton8.setOnClickListener {
//            lapTime()
        }
    }

    private fun start() {
        var minVal = minText.text.toString().toInt()
        var secVal = secText1.text.toString().toInt()
        var milliVal = milliText1.text.toString().toInt()
        var time = (minVal * 3600) + (secVal * 60) + milliVal
        timerTask = kotlin.concurrent.timer(period = 6) {
            time--
            val min = time / 3600
            val left = time % 3600
            val sec = left / 60
            val milli = left % 100

            if (milli < 0){
                reset()
            } else {
                handlerTest(min, sec, milli)
            }
        }
    }

    private fun handlerTest(min:Int, sec:Int, milli: Int) {
        val handler : Handler = object : Handler(Looper.getMainLooper()){
            override fun handleMessage(inputMessage: Message) {
                minText.setText(min.toString())
                secText1.setText(sec.toString())
                milliText1.setText(milli.toString())
            }
        }
        handler.obtainMessage().sendToTarget()
    }

    private fun pause() {
        timerTask?.cancel();
    }

    private fun reset() {
        timerTask?.cancel()
        isRunning = false
        minText.setText("00")
        secText1.setText("00")
        milliText1.setText("00")
        index = 1
    }

}