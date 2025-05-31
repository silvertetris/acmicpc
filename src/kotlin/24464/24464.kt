package kotlin.`24464`

fun main() {
    val n = readln().toInt()
    val dp = Array(n + 1) { LongArray(5) { 0 } }
    /*
    #1. states / subproblems
    첫 경우의 수는 5가지
    안먹거나, 1 먹거나 2먹거나 3먹거나 4먹거나
    dp[i][j] = j번째 식당을 i index 에 갈때 경우의 수
     */

    //#2. Base Cases
    for (i in 0 until 5) {
        dp[0][i] = 1
    }
    //#3. transition
    //dp[i][0] = dp[i-1]+dp[i-2]... 이웃한거 뺀거 더하면됨 각각
    for (i in 1 until n) {
        dp[i][0] = (dp[i - 1][1] + dp[i - 1][2] + dp[i - 1][3] + dp[i - 1][4])%1_000_000_007
        dp[i][1] = (dp[i - 1][0] + dp[i - 1][3] + dp[i - 1][4]) % 1_000_000_007
        dp[i][2] = (dp[i - 1][0] + dp[i - 1][4])%1_000_000_007
        dp[i][3] = (dp[i - 1][0] + dp[i - 1][1])%1_000_000_007
        dp[i][4] = (dp[i - 1][0] + dp[i - 1][1] + dp[i - 1][2])%1_000_000_007
    }

    //#4. final answer
    print((dp[n-1][0] + dp[n-1][1] + dp[n-1][2] + dp[n-1][3] + dp[n-1][4])%1_000_000_007)
}