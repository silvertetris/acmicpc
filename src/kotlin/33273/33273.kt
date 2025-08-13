fun main() {
    val br = System.`in`.bufferedReader()
    val (n, m) = br.readLine().split(" ").map { it.toInt() } //선택해야하는 수, 수 종류
    val x = Array<Pair<Int, Int>>(m+1) { 0 to 0 }
    for(i in 1 .. m) {
        val (u, v) = br.readLine().split(" ").map { it.toInt() }
        x[i] = u to v
    }
    x.sortBy { it.first }
    /*
    #1. States/subproblems
    dp[i][j] = i번째를 n제한(j)에 선택했을 경우 최대 value
     */
    val dp = Array(m + 1) { IntArray(n + 1) { -1 } }
    for(i in 0 .. m) {
        dp[i][n] = 0
    }
    for(i in 1 .. m) {
        for(j in 0 .. n) {
            dp[i][j] = dp[i-1][j]
            val prev = x[i-1].first
            val cur = x[i].first
            if(prev % cur !=0) {//배수 check
                break
            } else {
                if(j>=x[i].second) {
                    dp[i][j] = maxOf(dp[i][j], dp[i-1][j-x[i].second] + x[i].first*x[i].second)
                } else{
                    dp[i][n] = maxOf(dp[i][j] + x[i].first*n-j, dp[i][n])
                }
            }
        }
    }

    var max = 0
    for(i in 0 .. m) {
        max = maxOf(max, dp[i][n])
    }
    print(max)
}