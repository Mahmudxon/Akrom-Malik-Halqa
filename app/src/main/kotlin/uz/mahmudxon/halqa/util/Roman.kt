package uz.mahmudxon.halqa.util


/*
*   My own solution for https://leetcode.com/problems/integer-to-roman/
*   Mahmudxon Umarxonov
*/

object Roman {
    fun intToRoman(num: Int): String {

        var result = ""

        var v = num
        if (num == 0)
            return ""

        var n = 1
        while (v > 0) {
            var s = (v % 10)
            if (s == 9 || s == 4) {
                result = getRoman(s, n) + result
            } else if (s >= 5) {
                var temp = getRoman(5, n)
                while (s - 5 > 0) {
                    temp += getRoman(1, n)
                    s--
                }

                result = temp + result
            } else {
                while (s > 0) {
                    result = getRoman(1, n) + result
                    s--
                }
            }
            v /= 10
            n++
        }

        return result
    }

    private fun getRoman(i: Int, n: Int) = when (n) {
        1 -> onesSymbols(i)
        2 -> tensSymbols(i)
        3 -> hundredsSymbols(i)
        else -> "M"
    }


    private fun onesSymbols(v: Int) = when (v) {
        1 -> "I"
        4 -> "IV"
        5 -> "V"
        9 -> "IX"
        else -> ""
    }

    private fun tensSymbols(v: Int) = when (v) {
        1 -> "X"
        4 -> "XL"
        5 -> "L"
        9 -> "XC"
        else -> ""
    }

    private fun hundredsSymbols(v: Int) = when (v) {
        1 -> "C"
        4 -> "CD"
        5 -> "D"
        9 -> "CM"
        else -> ""
    }

}