fun main() {
    val br= System.`in`.bufferedReader()
    val a = br.readLine()
    val b = br.readLine()
    val dp = Array(1001) {IntArray(1001) {0} }
    for(i in 1 .. a.length) {
        for(j in 1.. b.length) {
            if(a[i-1] == b[j-1]) {
                dp[i][j] = 1 + dp[i-1][j-1]
            } else {
                dp[i][j] = maxOf(dp[i-1][j], dp[i][j-1])
            }
        }
    }
    print(dp[a.length][b.length])
}