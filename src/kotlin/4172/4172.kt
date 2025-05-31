package kotlin.`4172`

import kotlin.math.ln
import kotlin.math.pow
import kotlin.math.sin

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val dp = IntArray(1000001) { 0 }
    dp[0] = 1
    for (i in 1..1000000) {
        dp[i] = (dp[(i - i.toDouble().pow(0.5)).toInt()] + dp[ln(i.toDouble()).toInt()] + dp[(i * sin(i.toDouble()).pow(
            2.0
        )).toInt()])%1000000
    }
    while (true) {
        val temp = br.readLine().toInt()
        if (temp == -1) {
            break
        } else {
            bw.write("${dp[temp]}\n")
        }
    }
    bw.flush()
    bw.close()
}