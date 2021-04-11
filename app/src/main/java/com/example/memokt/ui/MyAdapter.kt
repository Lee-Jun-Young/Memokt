package com.example.memokt.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.memokt.data.model.MemoEntity
import com.example.memokt.databinding.ItemBinding
import com.example.memokt.util.MyDiffCallback

class MyAdapter(private val context: Context, var onDeleteListener : MainActivity) : ListAdapter<MemoEntity, MyAdapter.MyViewHolder>(MyDiffCallback) {

    private var memos : List<MemoEntity> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding = ItemBinding.inflate(LayoutInflater.from(context), parent, false)
        return MyViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return memos.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.onBind(memos[position])
    }

    inner class MyViewHolder(private val binding: ItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun onBind(memo: MemoEntity) {
            binding.memo = memo
            binding.executePendingBindings()

            binding.root.setOnLongClickListener {
                onDeleteListener.onDeleteListener(memo)
                true
            }
        }
    }

    fun setMemos(memos: List<MemoEntity>) {
        this.memos = memos
        notifyDataSetChanged()
    }

}