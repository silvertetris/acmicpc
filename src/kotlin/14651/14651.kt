fun main() {
    val n = readln().toInt()
    val dp = LongArray(n+1) {0}
    val INF = 1_000_000_000 + 9
    if(n == 1) {
        print(0)
        return
    }
    dp[2] = 2
    for(i in 3 .. n) {
        dp[i] = (dp[i-1]  * 3)%INF
    }
    print(dp[n]%INF)
}