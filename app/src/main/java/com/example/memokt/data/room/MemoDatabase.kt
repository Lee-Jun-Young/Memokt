package com.example.memokt.data.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.memokt.data.model.MemoEntity

@Database(entities = [MemoEntity::class], version = 1)
abstract class MemoDatabase : RoomDatabase(){
    abstract fun memoDAO() : MemoDAO

    companion object{
        var INSTANCE : MemoDatabase?= null

        fun getInstance(context: Context) : MemoDatabase? {
            if (INSTANCE == null) {
                synchronized(MemoDatabase::class) {
                    INSTANCE = Room.databaseBuilder(context.applicationContext,
                        MemoDatabase::class.java, "memo")
                        .fallbackToDestructiveMigration()
                        .build()
                }
            }
            return INSTANCE
        }
    }

}
