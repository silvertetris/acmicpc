fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.`out`.bufferedWriter()
    val n = br.readLine().toInt()
    val a = br.readLine().split(" ").map { it.toLong() }
    val b = br.readLine().split(" ").map { it.toLong() }
    /*
    #1. state / subproblems
    adp, bdp
    adp[i] = i cost일 때 a만 골랐을 때 최대 가치
    bdp[i] = i cost일 때 b만 골랐을 때 최대 가치
    dp[i] = i cost일 때 최종 전이 dp


    -> dp[i][j][k] = i 부터 j index에서 cost가 k 일때 최대 가치
     */
    val dp = Array(n) { Array(n) { LongArray(n + 1) { 0L } } }
    for (i in 0 until n) {
        dp[i][i][1] = a[i]
    }

    for (i in 0 until n) {
        for (j in i until n) {
            for (k in 2..n) {
                if (j - i + 1 < k) break

            }
        }
    }
}