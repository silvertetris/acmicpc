

fun main() {
    val n = readln().toInt()
    val dp = LongArray(n) {0}

    dp[0]=1
    for( i in 1 until n) {
        dp[i] = dp[i-1] +1
        for(j in 3 until i) {
            dp[i] = maxOf(dp[i], dp[i-j]*(j-1)) //여태까지 더한게 더 크냐? 아니면 그 전꺼를 여러분 붙여넣기 한게 더 크냐?
        }
    }
    print(dp[n-1])
}