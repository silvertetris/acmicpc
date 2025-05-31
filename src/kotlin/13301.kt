package kotlin

import java.math.BigInteger

fun main() {
    val n = readln().toInt()
    val arr = Array(81) { 0.toBigInteger() }
    fun dp(num: Int): BigInteger {
        if (num == 0 || num == 1) {
            return num.toBigInteger()
        } else if (arr[num] != 0.toBigInteger()) {
            return arr[num]
        } else {
            arr[num] = dp(num - 1) + dp(num - 2)
            return arr[num]
        }
    }

    print(4.toBigInteger()*dp(n)+2.toBigInteger()*dp(n-1))
}