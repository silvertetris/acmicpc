fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.`out`.bufferedWriter()
    val dp = Array(5) {IntArray(32769) {0} } //2^15 +1
    dp[0][0] = 1
    for(i in 1 until 182) {
        for(j in 1 .. 4) {
            for(k in i*i until 32768) {
                dp[j][k] += dp[j-1][k - i*i]
            }
        }
    }

    while(true) {
        val n = br.readLine().toInt()
        if(n == 0) break
        bw.write("${dp[1][n] + dp[2][n] + dp[3][n]+ dp[4][n]}\n")
    }
    bw.flush()
    bw.close()
}