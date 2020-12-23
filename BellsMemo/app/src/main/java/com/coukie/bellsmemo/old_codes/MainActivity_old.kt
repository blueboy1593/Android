package com.coukie.bellsmemo.old_codes

import com.coukie.bellsmemo.model.room.RoomMemo
import kotlinx.android.synthetic.main.activity_main.*

//import android.content.Intent
//import androidx.appcompat.app.AppCompatActivity
//import android.os.Bundle
//import android.view.View
//import android.widget.Button
//import android.widget.Toast
//import androidx.room.Room
//import com.coukie.bellsmemo.R
//import com.coukie.bellsmemo.model.Memo
//import com.coukie.bellsmemo.model.room.RoomHelper
//import kotlinx.android.synthetic.main.activity_main.*
//import kotlinx.android.synthetic.main.list_memo.view.*
//
//class MainActivity_old : AppCompatActivity() {
//
//    var helper: RoomHelper? = null
//    var writeMemoButton: Button? = null
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
////        helper = Room.databaseBuilder(this, RoomHelper::class.java, "room_memo")
////            .allowMainThreadQueries()
////            .build()
//        val memos = ArrayList<Memo>()
//        memos.add(Memo("첫 메모", "내용무"))
//        memos.add(Memo("두번째 메모", "내용무"))
//
//        val adapter = MemoAdapter(memos)
//        println(memos)
//        noterecyclerView.adapter = adapter
//
//        writeMemoButton = findViewById<View>(R.id.writeMemo) as Button
//        writeMemoButton!!.setOnClickListener {
//            val intent = Intent(this, WriteMemoActivity::class.java)
//            startActivity(intent)
////            println("button")
//        }
//    }
//}


//buttonSave.setOnClickListener {
//    if (editMemo.text.toString().isNotEmpty()){
//        val memo = RoomMemo(editMemo.text.toString(), "요기는 컨텐츠")
//        helper?.roomMemoDao()?.insert(memo)
//
//        adapter.listData.clear()
//        adapter.listData.addAll(helper?.roomMemoDao()?.getAll() ?: mutableListOf())
//        adapter.notifyDataSetChanged()
//        editMemo.setText("")
//    }
//}

//<EditText
//android:id="@+id/editMemo"
//android:layout_width="0dp"
//android:layout_height="100dp"
//android:layout_marginStart="8dp"
//android:layout_marginLeft="8dp"
//android:layout_marginEnd="8dp"
//android:layout_marginRight="8dp"
//android:layout_marginBottom="8dp"
//android:ems="10"
//android:hint="메모를 입력하세요"
//android:inputType="textMultiLine"
//app:layout_constraintBottom_toBottomOf="parent"
//app:layout_constraintEnd_toStartOf="@+id/buttonSave"
//app:layout_constraintStart_toStartOf="parent" />
//
//<Button
//android:id="@+id/buttonSave"
//android:layout_width="wrap_content"
//android:layout_height="100dp"
//android:layout_marginEnd="8dp"
//android:layout_marginRight="8dp"
//android:layout_marginBottom="8dp"
//android:text="저장"
//app:layout_constraintBottom_toBottomOf="parent"
//app:layout_constraintEnd_toEndOf="parent" />