

fun main() {
    val n = readln().toInt()
    val dp = IntArray(n + 1)
    for(i in 1.. n) {
        dp[i] = dp[i-1]+1
        if(i%2==0) {
            dp[i] = minOf(dp[i/2]+1, dp[i])
        }
        if(i%3==0) {
            dp[i] = minOf(dp[i/3]+1, dp[i])
        }
    }
    print(dp[n]-1)
}