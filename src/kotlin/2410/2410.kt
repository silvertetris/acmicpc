

fun main() {
    val n = readln().toInt()
    val dp = Array(1000001) {0}
    dp[1] = 1
    dp[2] = 2
    for(i in 3 .. n) {
        if(i%2==0) {
            dp[i] = (dp[i-1] + dp[i/2])%1000000000
        }
        else {
            dp[i] = dp[i-1]
        }
    }
    print(dp[n])
}