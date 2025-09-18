fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    val arr = br.readLine().split(" ").map { it.toInt() }.toIntArray()
    //#1. states/subproblem
    val dp = IntArray(1001) { 0 }
    dp[arr[0]] = 1
    for (i in 1 until n) {
        dp[arr[i]] = maxOf(dp[arr[i]], 1)
        for (j in 0 until arr[i]) {
            if (dp[j] != 0) {
                dp[arr[i]] = maxOf(dp[j] + 1, dp[arr[i]])
            }
        }
    }
    print(dp.max())
}