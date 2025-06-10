fun main() {
    val br = System.`in`.bufferedReader()
    val (n, k) = br.readLine().split(" ").map { it.toInt() }
    /*
    #1. states / subproblems
   dp[i][j] = i인덱스 일 때 j가 풀때
     */
    val dp = IntArray(n+1) {0}
    dp[0] = 1
    for(i in 1.. n) {
        if(i>=2) {
            dp[i] += dp[i-2]
        }
        if(k!=0 && i%k==0) {
            dp[i] += dp[i/k]
        }
        dp[i] += dp[i-1]
    }
    print(dp[n])
}