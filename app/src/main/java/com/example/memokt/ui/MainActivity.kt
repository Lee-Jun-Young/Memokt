package com.example.memokt.ui

import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.memokt.R
import com.example.memokt.data.model.MemoEntity
import com.example.memokt.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(), View.OnClickListener{

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel : MemoViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.lifecycleOwner = this
        binding.activity = this@MainActivity
        viewModel =  ViewModelProvider(this).get(MemoViewModel::class.java)
        setRecyclerView()
    }

    private fun setRecyclerView(){

        val adapter = MyAdapter(applicationContext,this)

        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.setHasFixedSize(true)

        viewModel.getAll().observe(this, Observer { memos ->
             adapter.setMemos(memos!!)
        })
    }

    override fun onClick(v: View){
        when (v.id) {
            R.id.btn_add -> {
                if (et_memo.text.toString().isNotEmpty()) {
                    val memo = MemoEntity(null, et_memo.text.toString())
                    viewModel.insert(memo)
                    et_memo.setText("")
                    et_memo.clearFocus()
                    val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                    inputMethodManager.hideSoftInputFromWindow(et_memo.windowToken, 0)
                }
            }
        }
    }

    fun onDeleteListener(memo: MemoEntity) {
            viewModel.delete(memo)
    }

}