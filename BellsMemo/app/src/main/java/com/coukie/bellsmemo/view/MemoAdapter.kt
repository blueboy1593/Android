package com.coukie.bellsmemo.view

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.coukie.bellsmemo.R
import com.coukie.bellsmemo.app.inflate
import com.coukie.bellsmemo.model.Memo
import kotlinx.android.synthetic.main.list_memo.view.*

class MemoAdapter(private val memos: ArrayList<Memo>) : RecyclerView.Adapter<MemoAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_memo, parent, false)
        return ViewHolder(view).apply {
            itemView.setOnClickListener{
//                Toast.makeText(parent.context, "클릭클릭", Toast.LENGTH_SHORT).show()
                val context = it.context
                val intent = Intent(context, DetailActivity::class.java)
                intent.putExtra("title", itemView.memoTitle.text)
                intent.putExtra("content", itemView.memoTime.text)
                context.startActivity(intent)
            }
        }
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