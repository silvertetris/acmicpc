

fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    val color = Array(n) { br.readLine().split(' ').map { it.toInt() }.toIntArray() }
    val INF = Int.MAX_VALUE-3000
    var answer = INF

    for (first in 0..2) {
        val dp = Array(n) { IntArray(3) { INF } }
        dp[0][first] = color[0][first]
        if (first != 0) dp[0][0] = INF
        if (first != 1) dp[0][1] = INF
        if (first != 2) dp[0][2] = INF

        for (i in 1 until n) {
            dp[i][0] = minOf(dp[i-1][1], dp[i-1][2]) + color[i][0]
            dp[i][1] = minOf(dp[i-1][0], dp[i-1][2]) + color[i][1]
            dp[i][2] = minOf(dp[i-1][0], dp[i-1][1]) + color[i][2]
        }

        for (last in 0..2) {
            if (last != first) {
                answer = minOf(answer, dp[n-1][last])
            }
        }
    }
    print(answer)
}