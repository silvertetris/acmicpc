fun main() {
    val br = System.`in`.bufferedReader()
    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    val s = br.readLine().split(" ").map { it.toInt() }.toIntArray()
    val (a, d) = br.readLine().split(" ").map { it.toInt() }
    //m점 이상 가산점, 한번 하면 d 동안 쉬어야함
    //#1. states/ subproblems
    //dp[i][j] = i번째 헌혈을 j일차에 진행했을 때 가산점
    val dp = Array(n/d + 3) {IntArray(n+d+1) {0} }

    for(i in 1 .. n) {
        dp[0][i] = dp[0][i-1] + s[i-1]
    }


    for(i in 1 .. n/d+2) {
        for(j in d .. n+d) {
            if(j>n) {
                dp[i][j] = maxOf(dp[i][j-1], dp[i-1][j-d]+a)
            } else {
                dp[i][j] = maxOf(dp[i][j-1]+ s[j-1], dp[i-1][j-d] + a)
            }
        }
    }

    for(i in 0 .. n/d+2) {
        if(dp[i][n]>=m) {
            print(i-d)
            return
        }
    }
    print(-1)
}
