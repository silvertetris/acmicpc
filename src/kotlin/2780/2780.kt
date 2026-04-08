fun main() {
    val br = System.`in`.bufferedReader()
    val bw= System.out.bufferedWriter()
    val t = br.readLine().toInt()
    val dp = Array(1001) {IntArray(10)}
    for(i in 0 until 10 ) {
        dp[1][i] = 1
    }
    val MOD = 1234567
    for(i in 2..1000) {
        dp[i][1] = (dp[i-1][2]+dp[i-1][4])%MOD
        dp[i][2] = (dp[i-1][1]+dp[i-1][3]+dp[i-1][5])%MOD
        dp[i][3] = (dp[i-1][2] + dp[i-1][6])%MOD
        dp[i][4] = (dp[i-1][1] + dp[i-1][5]+ dp[i-1][7])%MOD
        dp[i][5] = (dp[i-1][2]+dp[i-1][4]+dp[i-1][6]+dp[i-1][8])%MOD
        dp[i][6] = (dp[i-1][3]+dp[i-1][5]+dp[i-1][9])%MOD
        dp[i][7] = (dp[i-1][4]+dp[i-1][0] +dp[i-1][8])%MOD
        dp[i][8] = (dp[i-1][5]+dp[i-1][7]+dp[i-1][9])%MOD
        dp[i][9] = (dp[i-1][6] + dp[i-1][8])%MOD
        dp[i][0] = dp[i-1][7]
    }
    repeat(t) {
        val n = br.readLine().toInt()
        bw.write("${dp[n].sum()%MOD}\n")
    }
    bw.flush()
}