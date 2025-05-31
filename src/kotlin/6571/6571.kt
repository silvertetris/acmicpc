

import java.math.BigInteger

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    while (true) {
        val (a, b) = br.readLine().split(" ").map { it.toBigInteger() }
        if (a == 0.toBigInteger() && b == 0.toBigInteger()) break
        var cnt = 0
        val dp = Array<BigInteger>(100000) { BigInteger.ZERO }
        dp[0] = 0.toBigInteger()
        dp[1] = 1.toBigInteger()
        for (i in 2..100000) {
            dp[i] = dp[i - 1] + dp[i - 2]
            if (dp[i] > b) {
                break
            }
            if (dp[i] in a..b) {
                cnt++
            }
        }
        bw.write("$cnt\n")
    }
    br.close()
    bw.flush()
    bw.close()
}