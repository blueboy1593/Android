package com.coukie.bellsmemo.presenter

import android.content.Context
import androidx.room.Room
import com.coukie.bellsmemo.model.room.RoomHelper

fun MemoHelper (context: Context): RoomHelper? {
    var helper: RoomHelper? = null

    helper = Room.databaseBuilder(context, RoomHelper::class.java, "room_memo")
        .allowMainThreadQueries()
        .build()
    return helper
}