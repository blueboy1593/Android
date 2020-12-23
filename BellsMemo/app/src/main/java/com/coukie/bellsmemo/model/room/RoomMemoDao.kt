package com.coukie.bellsmemo.model.room

import androidx.room.*

@Dao
interface RoomMemoDao {
    @Query("select * from orm_memo")
    fun getAll(): List<RoomMemo>
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(memo: RoomMemo)
    @Delete
    fun delete(memo:RoomMemo)
    @Update
    fun update(memo: RoomMemo)
}