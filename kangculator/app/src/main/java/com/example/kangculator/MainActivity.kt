package com.example.kangculator

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    var edit1: EditText? = null
    var edit2: EditText? = null
    var btnAdd: Button? = null
    var btnSub: Button? = null
    var btnMul: Button? = null
    var btnDiv: Button? = null
    var textResult: TextView? = null
    var num1: String? = null
    var num2: String? = null
    var result: Int? = null
    var numButtons = arrayOfNulls<Button>(10)
    var numBtnIDs = arrayOf(
        R.id.BtnNum0,
        R.id.BtnNum1,
        R.id.BtnNum2,
        R.id.BtnNum3,
        R.id.BtnNum4,
        R.id.BtnNum5,
        R.id.BtnNum6,
        R.id.BtnNum7,
        R.id.BtnNum8,
        R.id.BtnNum9
    )
    var i = 0
    @SuppressLint("ClickableViewAccessibility", "SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        title = "초간단 계산기"
        edit1 = findViewById<View>(R.id.Edit1) as EditText
        edit2 = findViewById<View>(R.id.Edit2) as EditText
        btnAdd = findViewById<View>(R.id.BtnAdd) as Button
        btnSub = findViewById<View>(R.id.BtnSub) as Button
        btnMul = findViewById<View>(R.id.BtnMul) as Button
        btnDiv = findViewById<View>(R.id.BtnDiv) as Button
        textResult = findViewById<View>(R.id.TextResult) as TextView
        btnAdd!!.setOnTouchListener { arg0, arg1 ->
            num1 = edit1!!.text.toString()
            num2 = edit2!!.text.toString()
            result = num1!!.toInt() + num2!!.toInt()
            textResult!!.text = "계산 결과 : " + result.toString()
            false
        }
        btnSub!!.setOnTouchListener { arg0, arg1 ->
            num1 = edit1!!.text.toString()
            num2 = edit2!!.text.toString()
            result = num1!!.toInt() - num2!!.toInt()
            textResult!!.text = "계산 결과 : " + result.toString()
            false
        }
        btnMul!!.setOnTouchListener { arg0, arg1 ->
            num1 = edit1!!.text.toString()
            num2 = edit2!!.text.toString()
            result = num1!!.toInt() * num2!!.toInt()
            textResult!!.text = "계산 결과 : " + result.toString()
            false
        }
        btnDiv!!.setOnTouchListener { arg0, arg1 ->
            num1 = edit1!!.text.toString()
            num2 = edit2!!.text.toString()
            result = num1!!.toInt() / num2!!.toInt()
            textResult!!.text = "계산 결과 : " + result.toString()
            false
        }
        i = 0
        while (i < numBtnIDs.size) {
            numButtons[i] = findViewById<View>(numBtnIDs[i]) as Button
            i++
        }
        i = 0
        while (i < numBtnIDs.size) {
            val index: Int //꼭 필요함
            index = i
            numButtons[index]!!.setOnClickListener {
                if (edit1!!.isFocused == true) {
                    num1 = (edit1!!.text.toString()
                            + numButtons[index]!!.text.toString())
                    edit1!!.setText(num1)
                } else if (edit2!!.isFocused == true) {
                    num2 = (edit2!!.text.toString()
                            + numButtons[index]!!.text.toString())
                    edit2!!.setText(num2)
                } else {
                    Toast.makeText(applicationContext, "먼저 에디트텍스트를 선택하세요", Toast.LENGTH_SHORT)
                        .show()
                }
            }
            i++
        }
    }
}