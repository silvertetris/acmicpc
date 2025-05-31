

fun main() {
    val br = System.`in`.bufferedReader()
    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    val arr = Array(n) {IntArray(m)}
    for(i in 0 until n) {
        arr[i] = br.readLine().split(" ").map{it.toInt() }.toIntArray()
    }
    val dp = Array(n+1) { IntArray(m+1) {0} }
    for(i in 1 .. n) {
        for(j in 1 .. m) {
            dp[i][j] = maxOf(dp[i-1][j], dp[i][j-1]) + arr[i-1][j-1]
        }
    }
    print(dp[n][m])
}