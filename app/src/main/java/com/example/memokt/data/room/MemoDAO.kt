package com.example.memokt.data.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import com.example.memokt.data.model.MemoEntity

@Dao
interface MemoDAO {
    @Insert(onConflict = REPLACE)
    fun insert(memo: MemoEntity)

    @Query("SELECT * from memo")
    fun getAll() : LiveData<List<MemoEntity>>

    @Delete
    fun delete(memo: MemoEntity)

}
