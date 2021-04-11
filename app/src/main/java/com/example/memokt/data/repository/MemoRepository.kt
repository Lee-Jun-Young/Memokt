package com.example.memokt.data.repository

import android.app.Application
import androidx.lifecycle.LiveData
import com.example.memokt.data.model.MemoEntity
import com.example.memokt.data.room.MemoDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MemoRepository(application: Application) {

    private val memoDatabase = MemoDatabase.getInstance(application)!!
    private val memoDAO = memoDatabase.memoDAO()
    private val memos : LiveData<List<MemoEntity>> = memoDAO.getAll()

    fun getAll() : LiveData<List<MemoEntity>>{
        return memos
    }

    fun insert(memo : MemoEntity){
        CoroutineScope(Dispatchers.IO).launch {
            withContext(CoroutineScope(Dispatchers.Default).coroutineContext) {
                memoDAO.insert(memo)
            }
        }
    }

    fun delete(memo : MemoEntity) {
        CoroutineScope(Dispatchers.IO).launch {
            withContext(CoroutineScope(Dispatchers.Default).coroutineContext) {
                memoDAO.delete(memo)
            }
        }
    }

}
