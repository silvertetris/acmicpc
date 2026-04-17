fun main() {
    val (n, m) = readln().split(" ").map{it.toInt()}
    /*
    A는 1초고 B는 M초임
    싸움 시간 N
     */
    val dp = Array(n+1) {IntArray(2) {0} }
    for(i in 1 .. n) {
        if(i%m==0) {
            dp[i][0] += dp[i/m][1] +1
        }
        dp[i][0] = dp[i][0] + dp[i-1][0]
    }
    print(dp[n][0] + dp[n][1])
}