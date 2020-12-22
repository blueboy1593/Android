package com.coukie.bellsmemo.view

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.coukie.bellsmemo.R
import com.coukie.bellsmemo.app.inflate
import com.coukie.bellsmemo.model.Memo
import kotlinx.android.synthetic.main.list_memo.view.*

class MemoAdapter(private val memos: List<Memo>) : RecyclerView.Adapter<MemoAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(parent.inflate(R.layout.list_memo))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(memos[position])
    }

    override fun getItemCount(): Int {
        return memos.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private lateinit var memo: Memo
        fun bind(memo: Memo) {
            this.memo = memo
            println(memo)
            itemView.memoTitle.text = memo.title
            itemView.memoTime.text = memo.content
        }
    }
}