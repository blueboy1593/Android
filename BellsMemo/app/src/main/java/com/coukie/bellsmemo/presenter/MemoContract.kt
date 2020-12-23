package com.coukie.bellsmemo.presenter

import androidx.lifecycle.LiveData

class MemoContract {

    interface Presenter {
        fun intentWriteMemoActivity()
        fun clearAllCreatures()
    }

    interface View {

    }
}