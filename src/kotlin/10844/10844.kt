package kotlin.`10844`

fun main() {
    val n = readln().toInt()
    val dp = Array(101) {LongArray(10) {0} }
    val MOD = 1000000000
    for(i in 0 until 10) {
        dp[1][i] = 1
    }
    for(i in 2 .. n) {
        dp[i][0] = dp[i-1][1]%MOD
        for(j in 1..8) {
            dp[i][j] = (dp[i-1][j-1] + dp[i-1][j+1])%MOD
        }
        dp[i][9] = dp[i-1][8]%MOD
    }
    var result = 0L
    for(i in 1 ..9) {
        result = (result+dp[n][i])%MOD
    }
    print(result)
}