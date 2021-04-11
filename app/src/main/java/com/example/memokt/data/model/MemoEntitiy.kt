package com.example.memokt.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "memo")
data class MemoEntity(
    @PrimaryKey(autoGenerate = true)
    var id: Long?,

    @ColumnInfo(name = "memo")
    var memo: String = ""
)
