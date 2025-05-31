

fun main() {
    val br = System.`in`.bufferedReader()
    val (C, N) = br.readLine().split(" ").map { it.toInt() }
    val cost = IntArray(N)
    val plus = IntArray(N)
    repeat(N) {
        val (a, b) = br.readLine().split(" ").map { it.toInt() }
        cost[it] = a
        plus[it] = b
    }

    val maxC = C + 100 * 100
    val dp = IntArray(maxC + 1) { Int.MAX_VALUE }
    dp[0] = 0

    for (i in 0 until N) {
        for (c in plus[i]..maxC) {
            if (dp[c - plus[i]] != Int.MAX_VALUE) {
                dp[c] = minOf(dp[c], dp[c - plus[i]] + cost[i])
            }
        }
    }

    var answer = Int.MAX_VALUE
    for (i in C..maxC) {
        answer = minOf(answer, dp[i])
    }
    println(answer)
}