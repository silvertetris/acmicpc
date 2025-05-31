package kotlin.`25634`

fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    val a = br.readLine().split(" ").map { it.toInt() }
    val b = br.readLine().split(" ").map { it.toInt() }
    val dp = LongArray(n+1) {0}
    var ans = 0

    for( i in 1 .. n) {
        if(b[i-1] == 1) {
            ans+=a[i-1]
            dp[i] = maxOf(dp[i-1] - a[i-1], -a[i-1].toLong())
        } else {
            dp[i] = maxOf(dp[i-1] + a[i-1], a[i-1].toLong())
        }
    }

    var max = -123123123L
    for(i in 1.. n) {
        max = maxOf(max, dp[i])
    }
    print(max+ans)
}