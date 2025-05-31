

fun main() {
    val br = System.`in`.bufferedReader()
    val n  = br.readLine().toInt()
    val a = br.readLine().split(" ").map { it.toInt() }
    val dp = a.toMutableList()
    for(i in 0 until n) {
        for(j in 0 until i) {
            if(a[i]<a[j]) {
                dp[i] = maxOf(dp[i], dp[j]+a[i])
            }
        }
    }
    print(dp.max())
}