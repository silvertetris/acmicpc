fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    val a = br.readLine().split(" ").map { it.toInt() }.toIntArray()
    val dp = IntArray(n+1) {0}
    dp[0] = a[0]
    var max= dp[0]
    for(i in 1 until n) {
        dp[i] = maxOf(dp[i-1] + a[i], a[i])
        max = maxOf(dp[i] , max)
    }
    print(max)
}