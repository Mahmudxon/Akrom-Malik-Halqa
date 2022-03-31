package uz.mahmudxon.halqa.util

import android.util.Log

val Any.TAG: String
    get() = "TTT@${this.javaClass.canonicalName?.split('.')?.last()}"

fun Any.log(msg: String) = Log.d(TAG, msg)