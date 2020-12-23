package com.coukie.bellsmemo.presenter

import android.content.Intent
import android.view.View
import androidx.core.content.ContextCompat.startActivity
import com.coukie.bellsmemo.view.MainActivity
import com.coukie.bellsmemo.view.WriteMemoActivity

class MemoPresenter {
    fun intentWriteMemoActivity(view: View, activity: Class<WriteMemoActivity>) {
        view.setOnClickListener {
            val intent = Intent(view.context, activity)
            view.context.startActivity(intent)
        }
    }

    fun intentMainActivity(view: View, activity: MainActivity) {
        val intent = Intent(view.context, activity::class.java)
        view.context.startActivity(intent)
    }
}