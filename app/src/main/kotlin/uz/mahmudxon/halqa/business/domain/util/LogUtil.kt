package uz.mahmudxon.halqa.business.domain.util

val Any.TAG: String
    get() = "TTT@${this.javaClass.canonicalName?.split('.')?.last()}"