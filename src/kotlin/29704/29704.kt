fun main() {
    val br = System.`in`.bufferedReader()
    val(n, t) = br.readLine().split(" ").map { it.toInt() }
    val d = IntArray(n)
    val m = IntArray(n)
    val dp = Array(n+1) { IntArray(t+1) {0} }
    for(i in 0 until n) {
        val temp = br.readLine().split(" ").map { it.toInt() }
        d[i] = temp[0]
        m[i] = temp[1]
    }

    for(i in 1.. n) {
        for(j in 1.. t) {
            if(j<d[i-1]) {
                dp[i][j] = dp[i-1][j]
                continue
            }
            dp[i][j] = maxOf(dp[i-1][j], dp[i-1][j-d[i-1]]+m[i-1])
        }
    }
    print(m.sum()-dp[n][t])
}