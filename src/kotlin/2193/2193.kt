fun main() {
    val n = readln().toInt()
    val dp = LongArray(n+1) {0}
    if(n==1) {
        print(1)
        return
    }
    dp[1] = 1
    for(i in 2..n) {
        dp[i] = dp[i-1]+ dp[i-2]
    }
    print(dp[n])
}