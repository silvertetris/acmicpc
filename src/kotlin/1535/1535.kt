fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    val l = br.readLine().split(" ").map { it.toInt() }
    val j = br.readLine().split(" ").map { it.toInt() }
    val arr = Array(n) {Pair(0,0)}
    for(i in 0 until n) {
        arr[i] = l[i] to j[i]
    }
    arr.sortByDescending { it.second }
    val dp = Array(n+1) {IntArray(101) {0} }
    for(i in 1..n) {
        for(k in 1.. 100) {
            if(k-arr[i-1].first<=0) {
                dp[i][k] = dp[i-1][k]
                continue
            }
            dp[i][k] = maxOf(dp[i-1][k], dp[i-1][k-arr[i-1].first]+arr[i-1].second)
        }
    }
    print(dp[n][100])
}