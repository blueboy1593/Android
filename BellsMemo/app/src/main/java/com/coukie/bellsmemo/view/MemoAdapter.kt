package com.coukie.bellsmemo.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.coukie.bellsmemo.R
import com.coukie.bellsmemo.model.room.RoomHelper
import com.coukie.bellsmemo.model.room.RoomMemo
import kotlinx.android.synthetic.main.list_memo.view.*

class MemoAdapter() : RecyclerView.Adapter<MemoAdapter.ViewHolder>() {
    var helper: RoomHelper? = null
    var listData = mutableListOf<RoomMemo>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_memo, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val memo = listData.get(position)
        holder.setMemo(memo)
    }

    override fun getItemCount(): Int {
        return listData.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var savedMemo: RoomMemo? = null
        init {
            itemView.buttonDelete.setOnClickListener {
                helper?.roomMemoDao()?.delete(savedMemo!!)
                listData.remove(savedMemo)
                notifyDataSetChanged()
            }
        }


        fun setMemo(memo: RoomMemo) {
            itemView.memoTitle.text = memo.title
            itemView.memoContent.text = memo.content

            this.savedMemo = memo
        }
    }
}