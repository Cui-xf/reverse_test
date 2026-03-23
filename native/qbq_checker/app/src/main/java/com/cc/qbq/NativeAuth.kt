package com.cc.qbq

import android.util.Log

object NativeAuth {
    init {
        System.loadLibrary("password_checker")
    }

    fun aaa(input: String): Boolean {
        Log.i("LALALA", "输入：$input")
        return verifyPassword(input)
    }

    external fun verifyPassword(input: String): Boolean
}
