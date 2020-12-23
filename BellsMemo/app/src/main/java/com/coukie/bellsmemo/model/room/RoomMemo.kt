package com.coukie.bellsmemo.model.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "orm_memo")
class RoomMemo {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo
    var no:Long?=null
    @ColumnInfo
    var title:String=""
    @ColumnInfo
    var content:String=""
    constructor(title:String, content:String) {
        this.title = title
        this.content = content
    }
}