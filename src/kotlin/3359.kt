

import kotlin.math.abs

fun main() {
    val n = readln().toInt()
    val arr = Array(n) { IntArray(2) }
    val dp = Array(n) { IntArray(2) }
    for (i in 0 until n) {
        arr[i] = readln().split(" ").map { it.toInt() }.toIntArray()
    }
    dp[0][0] = arr[0][0]
    dp[0][1] = arr[0][1]
    for (i in 1 until n) {
        dp[i][0] = maxOf(
            dp[i - 1][0] + abs(arr[i - 1][1] - arr[i][1]), dp[i - 1][1] + abs(arr[i - 1][0] - arr[i][1])
        ) + arr[i][0]
        dp[i][1] = maxOf(
            dp[i - 1][0] + abs(arr[i - 1][1] - arr[i][0]), dp[i - 1][1] + abs(arr[i - 1][0] - arr[i][0])
        ) + arr[i][1]
    }
    print(maxOf(dp[n - 1][0], dp[n - 1][1]))
}