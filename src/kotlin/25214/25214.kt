import java.util.StringTokenizer

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val n = br.readLine().toInt()
    val str= StringTokenizer(br.readLine())
    val arr = IntArray(n)
    for(i in 0 until n) {
        arr[i] = str.nextToken().toInt()
    }
    var dp = IntArray(n)
    dp[0] = 0
    var min = arr[0]
    for(i in 1 until n) {
        min = minOf(min, arr[i])
        dp[i] = maxOf(dp[i-1], arr[i]-min)
    }
    print(dp.joinToString(" "))
}