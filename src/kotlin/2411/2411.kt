package kotlin.`2411`

fun main() {
    val br = System.`in`.bufferedReader()
    val (n, m, a, b) = br.readLine().split(" ").map { it.toInt() }
    val dp = Array(n + 1) { IntArray(m + 1) { 0 } }
    val item = Array(a) { Pair(0, 0) }
    val obstacle = Array(b) { Pair(0, 0) }
    for (i in 0 until a) {
        val (num1, num2) = br.readLine().split(" ").map { it.toInt() }
        item[i] = Pair(num1-1, num2-1)
    }
    for (i in 0 until b) {
        val (num1, num2) = br.readLine().split(" ").map { it.toInt() }
        obstacle[i] = Pair(num1-1, num2-1)
    }
    item.sortWith(compareBy<Pair<Int, Int>> { it.first }.then(compareBy { it.second }))
    obstacle.sortBy { it.first }
    dp[0][0] = 1
    var currentX = 0
    var currentY = 0
    for (i in 0 until a) {
        val x = item[i].first
        val y = item[i].second
        for (j in currentX .. x) {
            for (k in currentY .. y) {
                if(!obstacle.contains(Pair(j, k))&&j>0) {
                    dp[j][k] += dp[j-1][k]
                }
                if(!obstacle.contains(Pair(j, k))&&k>0) {
                    dp[j][k] += dp[j][k-1]
                }
            }
        }
        currentX= x
        currentY= y
    }
    for(i in currentX until n) {
        for(j in currentY until m) {
            if(!obstacle.contains(Pair(i,j))){
                dp[i][j] = dp[i-1][j]
            }
            if(!obstacle.contains(Pair(i,j))) {
                dp[i][j] = dp[i][j-1]
            }
        }
    }
    print(dp[n-1][m-1])
}