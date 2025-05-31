package kotlin.`11053`

fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    val a = br.readLine().split(" ").map { it.toInt() }

    val dp = IntArray(n) { 1 }

    for (i in 0 until n) {
        for (j in 0 until i) {
            if (a[j] < a[i]) {
                dp[i] = maxOf(dp[i], dp[j] + 1)
            }
        }
    }
    print(dp.max())
}