package kotlin.`19622`

fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    val count = IntArray(n)
    repeat(n) {
        val (_, _, c) = br.readLine().split(" ").map { it.toInt() }
        count[it] = c
    }
    if (n == 1) {
        print(count[0])
        return
    }
    val dp = IntArray(n)
    dp[0] = count[0]
    dp[1] = maxOf(count[0], count[1])
    for (i in 2 until n) {
        dp[i] = maxOf(dp[i-1], dp[i-2]+count[i])
    }
    print(dp[n-1])
}