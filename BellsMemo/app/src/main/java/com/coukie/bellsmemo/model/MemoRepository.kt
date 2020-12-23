package com.coukie.bellsmemo.model

import com.coukie.bellsmemo.model.room.RoomMemo

interface MemoRepository {
    fun getAll(): List<RoomMemo>
    fun insert(memo: RoomMemo)
    fun delete(memo:RoomMemo)
}