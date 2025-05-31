package kotlin

import java.math.BigInteger

fun main() {
    var arr = MutableList<BigInteger>(10001) { 0.toBigInteger() }
    val n = readln().toInt()
    fun dp(n: Int): BigInteger {
        if (n == 0 || n == 1) return n.toBigInteger()
        if (arr[n] != 0.toBigInteger()) return arr[n]
        arr[n] = dp(n - 1) + dp(n - 2)
        return arr[n]
    }
    print(dp(n))
}