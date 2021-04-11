package com.example.memokt.ui

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.memokt.data.model.MemoEntity
import com.example.memokt.data.repository.MemoRepository

class MemoViewModel(application: Application) : AndroidViewModel(application){

    private val repository = MemoRepository(application)
    private val memos = repository.getAll()

    fun getAll() : LiveData<List<MemoEntity>>{
        return this.memos
    }

    fun insert(memo: MemoEntity){
        repository.insert(memo)
    }

    fun delete(memo : MemoEntity){
        repository.delete(memo)
    }

}