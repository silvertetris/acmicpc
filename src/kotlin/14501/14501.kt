

fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    val t = IntArray(n)
    val p = IntArray(n)
    for (i in 0 until n) {
        val (a, b) = br.readLine().split(" ").map { it.toInt() }
        t[i] = a
        p[i] = b
    }

    val dp = IntArray(n + 1)

    for (i in 0 until n) {
        if (i + t[i] <= n) {
            for (j in i + t[i]..n) {
                if (dp[j] < dp[i] + p[i]) {
                    dp[j] = dp[i] + p[i]
                }
            }
        }
    }

    print(dp[n])
}