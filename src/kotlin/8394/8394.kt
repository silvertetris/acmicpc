

fun main() {
    val n = readln().toInt()
    val dp = LongArray(n+1) {0}
    dp[1] = 1
    dp[2] = 2
    for(i in 3..n) {
        dp[i] = (dp[i-1] + dp[i-2])%10
    }
    print(dp[n])
}