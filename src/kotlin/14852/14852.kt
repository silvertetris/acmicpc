fun main() {
    val n = readln().toInt()
    val dp = LongArray(n+1) {0}
    val MOD = 1_000_000_007
    dp[0] = 1
    dp[1] = 2
    for(i in 2..n) {
        dp[i] = dp[i-1] + dp[i-2] + 4
    }
    print(dp[n])
}