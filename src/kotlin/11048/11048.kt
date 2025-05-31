package kotlin.`11048`

fun main() {
    val br = System.`in`.bufferedReader()
    val(n, m) = br.readLine().split(" ").map { it.toInt() }
    val a = Array(n) {IntArray(m) {0} }
    for(i in 0 until n) {
        a[i] = br.readLine().split(" ").map { it.toInt() }.toIntArray()
    }
    /*
    #1. states/ subproblems
    dp[i][j] = i, j 인덱스일때 최대 사탕 갯수
     */
    val dp = Array(n+1) { IntArray(m+1) {0} }
    //#2. Base Cases
    dp[1][1] = a[0][0]

    //#3. transitions
    for(i in 1 .. n) {
        for(j in 1 .. m) {
            dp[i][j] = maxOf(dp[i-1][j-1], dp[i-1][j], dp[i][j-1]) + a[i-1][j-1] //x, y, 대각
        }
    }

    //#4. final answer
    print(dp[n][m])
}