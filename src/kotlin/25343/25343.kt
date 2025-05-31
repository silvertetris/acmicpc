

fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    val arr = Array(n) {IntArray(n) }
    for(i in 0 until n) {
        arr[i] = br.readLine().split(" ").map { it.toInt() }.toIntArray()
    }
    val dp = Array(n+1) {IntArray(n+1){1} }
    for(i in 0 until n) {
        for(j in 0 until n) {
            for(k in 0 ..i) {
                for(p in 0 .. j) {
                    if(arr[k][p]<arr[i][j]) {
                        dp[i][j] = maxOf(dp[i][j], dp[k][p]+1)
                    }
                }
            }
        }
    }
    val ans = dp.maxOf { it.max() }
    print(ans)
}