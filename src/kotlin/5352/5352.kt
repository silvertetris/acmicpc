fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val t = br.readLine().toInt()
    repeat(t) {
        val (n, m) = br.readLine().split(" ").map { it.toInt() }
        val arr = Array(n) { IntArray(m) { 0 } }
        for (i in 0 until n) {
            val line = br.readLine()
            for (j in 0 until m) {
                if (line[j] == 'C') {
                    arr[i][j] = 1
                }
            }
        }
        val dp = Array(n + 1) { IntArray(m + 1) { 0 } }
        for (i in 1..n) {
            for (j in 1..m) {
                dp[i][j] = maxOf(dp[i - 1][j], dp[i][j - 1]) + arr[i - 1][j - 1]
            }
        }
        bw.write("${dp[n][m]}\n")
    }
    bw.flush()
}