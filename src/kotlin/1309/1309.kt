fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    val dp = Array(n+1) {IntArray(3) {0} }
    dp[0][0]= 1
    dp[0][1] = 1
    dp[0][2] = 1
    for(i in 1.. n) {
        dp[i][0] = dp[i-1][0] + dp[i-1][1] + dp[i-1][2]
        dp[i][1] = dp[i-1][0] + dp[i-1][2]
        dp[i][2] = dp[i-1][0] + dp[i-1][1]
        dp[i][0] %= 9901
        dp[i][1] %= 9901
        dp[i][2] %= 9901
    }
    print((dp[n-1][0] + dp[n-1][1] + dp[n-1][2])%9901)
}