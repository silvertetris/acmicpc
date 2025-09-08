fun main() {
    val n = readln().toInt()
    val dp = IntArray(n)
    dp[0] = 1
    for(i in 1 until n) {
        if(i == 1) {
            dp[1] = 2
        }
        else {
            dp[i] = dp[i-1] + dp[i-2]
        }
        dp[i] = dp[i]%15746
    }
    print(dp[n-1])
}