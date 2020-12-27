package com.coukie.bellstimeapp.view

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.os.Message
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.coukie.bellstimeapp.R
import kotlinx.android.synthetic.main.stopwatch_fragment.*
import java.util.*

class StopwatchFragment : Fragment() {

    private var time = 0
    private var isRunning = false
    private var timerTask: Timer? = null
    private var index :Int = 1

    override fun onResume() {
        super.onResume()
        floatingActionButton.setOnClickListener {
            start()
        }

        floatingActionButton2.setOnClickListener {
            pause()
        }

        floatingActionButton3.setOnClickListener {
            reset()
        }

        floatingActionButton4.setOnClickListener {
            lapTime()
        }
    }

    private fun start() {
        timerTask = kotlin.concurrent.timer(period = 10) {
            time++
            val sec = time / 100
            val milli = time % 100
            handlerTest(sec, milli)
        }
    }

    private fun handlerTest(sec:Int, milli: Int) {
        val handler : Handler = object : Handler(Looper.getMainLooper()){
            override fun handleMessage(inputMessage: Message) {
                secText.text = sec.toString()
                milliText.text = milli.toString()
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
        secText.text = "0"
        milliText.text = "00"
        lap_Layout.removeAllViews()
        index = 1
        time = 0
    }

    private fun lapTime() {
        val lapTime = time
        val textView = TextView(activity).apply {
            setTextSize(20f)
        }
        textView.text = "${lapTime / 100}.${lapTime % 100}"

        lap_Layout.addView(textView,0)
        index++
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.stopwatch_fragment, container, false)
    }
}