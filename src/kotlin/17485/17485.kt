fun main() {
    val br = System.`in`.bufferedReader()
    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    val arr = Array(n) { br.readLine().split(" ").map { it.toInt() }.toIntArray() }
    /*
    #1. states/subproblems
    dp(i, j, k) = i, j 위치에서 k이동을 했을때 최소 연료 값
     */
    val dp = Array(n + 1) { Array(m + 2) { IntArray(3) { Int.MAX_VALUE - 1000 } } }
    //#2. Base Cases
    for (i in 0..m + 1) {
        dp[0][i].fill(0)
    }
    //#3. transitions
    for (i in 1..n) {
        for (j in 1..m) {
            for (k in 0 until 3) {
                if(k ==0) {
                    dp[i][j][k] = minOf(dp[i-1][j][1],dp[i-1][j+1][2])
                }
                else if(k==1) {
                    dp[i][j][k] = minOf(dp[i-1][j-1][0], dp[i-1][j+1][2])
                }
                else {
                    dp[i][j][k] = minOf(dp[i-1][j-1][0], dp[i-1][j][1])
                }
                dp[i][j][k] += arr[i - 1][j - 1]
            }
        }
    }
    //#4. final answer
    var ans = Int.MAX_VALUE
    for (i in 1 .. m) {
        for (j in 0 until 3) {
            ans = minOf(ans, dp[n][i][j])
        }
    }
    print(ans)
}