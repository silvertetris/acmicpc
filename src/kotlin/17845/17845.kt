

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val (n, k) = br.readLine().split(" ").map { it.toInt() }
    val time = IntArray(k) {0}
    val value = IntArray(k) {0}
    for (i in 0 until k) {
        val temp = br.readLine().split(" ")
        value[i] = temp[0].toInt()
        time[i] = temp[1].toInt()
    }
    /*
    #1. states/ subproblems
    knapsack problem
    dp[i][j] = i: 물건 index ,j : time limit => 총 담은 value
     */

    // #2. Base Cases -> 0
    val dp = Array(k + 1) { IntArray(n + 1) { 0 } }

    for (i in 1..k) {
        for (j in 0..n) {
            //#3. transition (knapsack)
            dp[i][j] = dp[i - 1][j]
            if(time[i-1]<=j) {
                dp[i][j] = maxOf(dp[i][j], value[i-1]+dp[i-1][j-time[i-1]])
            }
        }
    }
    //#4. final answer
    bw.write("${dp[k][n]}")
    bw.flush()
    bw.close()
}