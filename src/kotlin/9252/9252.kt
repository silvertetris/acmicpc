

fun main() {
    val br = System.`in`.bufferedReader()
    val a = br.readLine()
    val b = br.readLine()
    val dp = Array(1001) { IntArray(1001) { 0 } }

    for (i in 1..a.length) {
        for (j in 1..b.length) {
            if (a[i - 1] == b[j - 1]) {
                dp[i][j] = dp[i - 1][j - 1] + 1
            } else {
                dp[i][j] = maxOf(dp[i - 1][j], dp[i][j - 1])
            }
        }
    }
    var answer = ""
    var l = a.length
    var r = b.length
    while (l > 0 && r > 0) {
        if (dp[l][r] == dp[l - 1][r]) {
            l--
        } else if (dp[l][r] == dp[l][r - 1]) {
            r--
        } else {
            answer += a[l - 1]
            l--
            r--
        }
    }
    println(dp[a.length][b.length])
    print(answer.reversed())
}