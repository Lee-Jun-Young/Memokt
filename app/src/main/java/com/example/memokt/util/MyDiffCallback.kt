package com.example.memokt.util

import androidx.recyclerview.widget.DiffUtil
import com.example.memokt.data.model.MemoEntity

object MyDiffCallback : DiffUtil.ItemCallback<MemoEntity>() {
    override fun areItemsTheSame(oldItem: MemoEntity, newItem: MemoEntity): Boolean {
        return oldItem.memo == newItem.memo
    }

    override fun areContentsTheSame(oldItem: MemoEntity, newItem: MemoEntity): Boolean {
        return oldItem == newItem
    }
}