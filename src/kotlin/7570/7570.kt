fun main() {
    val br =System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    val arr = br.readLine().split(" ").map { it.toInt() }.toIntArray()
    val dp = IntArray(n+1) {0}
    for(i in 0 until n) {
        dp[arr[i]] = dp[arr[i]-1]+1
    }
    print(n-dp.max())
}