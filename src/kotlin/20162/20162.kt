fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    val snack = IntArray(n)
    for(i in 0 until n) {
        snack[i] = br.readLine().toInt()
    }
    //#1. states/ subproblems
    val dp = IntArray(100_001) {0}//dp[i] = i를 마지막으로 먹었을 때 최대 값

    //#3. transition
    for(i in 0 until n) {
        var temp = 0
        for(j in 1 until snack[i]) {
            temp = maxOf(temp, dp[j])
        }
        dp[snack[i]] = snack[i] + temp
    }
    //#4. final answer
    print(dp.max())
}