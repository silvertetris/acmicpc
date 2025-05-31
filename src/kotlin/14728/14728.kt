fun main() {
    val br = System.`in`.bufferedReader()
    val (n, t) = br.readLine().split(" ").map { it.toInt() } // t = time limit
    val k = IntArray(n)
    val s = IntArray(n)
    for(i in 0 until n) {
        val temp = br.readLine().split(" ").map { it.toInt() }
        k[i] = temp[0] //time (limit)
        s[i] = temp[1]// value
    }
    //그냥 무난한 0/1 knapsack
    val dp = Array(n+1) {IntArray(t+1) }

    for(i in 1 .. n) {
        for(j in 1.. t) {
            if(k[i-1]>j) dp[i][j] = dp[i-1][j]
            else {
                dp[i][j] = maxOf(dp[i-1][j], dp[i-1][j-k[i-1]]+s[i-1])
            }
        }
    }
    print(dp[n][t])
}