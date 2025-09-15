fun main() {
    val n = readln().toInt()
    val dp = Array(n+1) {IntArray(3) {0} }
    dp[0][2] = 1
    dp[1][0] = 1//att
    dp[1][1] = 1//late
    dp[1][2] = 1//absc
    for(i in 2..n) {
        dp[i][0] = (dp[i-1][0] + dp[i-1][1] + dp[i-1][2])%1_000_000
        dp[i][1] = (dp[i-1][0] + dp[i-1][2]) %1_000_000
        dp[i][2] = (dp[i-1][0] + dp[i-1][1] + dp[i-2][2]) %1_000_000
    }
    print(dp[n][0] + dp[n][1] + dp[n][2])
}