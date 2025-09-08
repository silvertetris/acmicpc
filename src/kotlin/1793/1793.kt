import java.math.BigInteger

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val dp = Array<BigInteger> (251) {0.toBigInteger()}
    dp[0] = 1.toBigInteger()
    dp[1] = 1.toBigInteger()
    for(i in 2.. 250) {
        dp[i] = dp[i-1] + dp[i-2] * 2.toBigInteger()
    }
    while(true) {
        val line = br.readLine() ?: break
        val n = line.toInt()
        bw.write("${dp[n]}\n")
        bw.flush()
    }
}