fun main() {
    val br = System.`in`.bufferedReader()
    val s = br.readLine()
    fun isPelindrom(s: String): Boolean {
        if (s == s.reversed()) return true
        else return false
    }
    /*
    #1. states/subproblems
    dp[i][j][k][p] = 1, 2, 3, 4 연산 횟수에 따른 s 변화
     */
    val dp = Array(50) { Array(50) { Array(50) { Array(2) { "" } } } }
    //#2. Base Cases
    dp[0][0][0][0] = s
    var cnt = Int.MAX_VALUE

    //#3. transition
    for (i in 0 until 50) {
        var first = ""
        var second = ""
        for (j in 0 until 50) {
            for (k in 0 until 50) {
                for (p in 0 until 2) {
                    if(dp[i][j][k][p].length %2==0){
                        first = dp[i][j][k][p].substring(0,dp[i][j][k][p].length/2-1)
                        second = dp[i][j][k][p].substring(dp[i][j][k][p].length/2, dp[i][j][k][p].length)
                    } else {
                        first = dp[i][j][k][p].substring(0,dp[i][j][k][p].length/2)
                        second = dp[i][j][k][p].substring(dp[i][j][k][p].length/2+1, dp[i][j][k][p].length)
                    }
                    if(isPelindrom(dp[i][j][k][p])) {
                        cnt= minOf(cnt, i+j+k+p)
                        continue
                    }
                }
            }
        }
    }

    //#4.final answer
    print(cnt)
}