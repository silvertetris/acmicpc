

fun main() {
    val (a, k) = readln().split(" ").map { it.toInt() }
    val dp = IntArray(k+2) {Int.MAX_VALUE}
    dp[a] = 0

    for(i in a .. k) {
        dp[i+1] = minOf(dp[i+1], dp[i] +1)
        if (i * 2 <= k) dp[i * 2] = minOf(dp[i * 2], dp[i] + 1)
    }
    print(dp[k])
}