fun main() {
    val (n, m) = readln().split(" ").map{it.toInt()}
    /*
    A는 1초고 B는 M초임
    싸움 시간 N
     */
    val dp = IntArray(n+1){0}
    dp[0] = 1
    for(i in 1..n) {
        dp[i] = dp[i-1]
        if(i>=m) {
            dp[i] = (dp[i]+dp[i-m])%1_000_000_007
        }
    }
    print(dp[n])
}