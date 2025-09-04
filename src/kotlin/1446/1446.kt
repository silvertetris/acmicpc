fun main() {
    val br = System.`in`.bufferedReader()
    val(n, d) = br.readLine().split(" ").map { it.toInt() }
    val dp = IntArray(d+1) {Int.MAX_VALUE-10000}
    dp[0] = 0
    val arr = Array(n) { Triple(0, 0, 0) }
    for(i in 0 until n) {
        val (u, v, w) = br.readLine().split(" ").map { it.toInt() }
        arr[i] = Triple(u, v, w)
    }
    for(i in 1 .. d) {
        dp[i] = minOf(dp[i-1] +1, i)
        for(j in 0 until n) {
            if(arr[j].second == i) {
                dp[i] = minOf(dp[i], dp[arr[j].first]+arr[j].third, i)
            }
        }
    }
    print(dp[d])
}