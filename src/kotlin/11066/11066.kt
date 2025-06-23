fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.`out`.bufferedWriter()
    val t = br.readLine().toInt()
    repeat(t) {
        val k = br.readLine().toInt()
        val fileSize = br.readLine().split(" ").map { it.toInt() }.toIntArray()
        val preSum = IntArray(k)
        preSum[0] = fileSize[0]
        for(i in 1 until k) {
            preSum[i] = preSum[i-1] + fileSize[i]
        }
        /*
        #1. states/subproblems
        dp[i][j] = l, r 구간 합쳤을 때 최소 합
         */
        val dp = Array(k+1) {IntArray(k+1) {Integer.MAX_VALUE-1_000_000} }
        for(i in 1 until k) {
            var l = 1
            var r = i+1
            for(j in 0 until k-i) {
                for(p in r-i .. r-1) {
                    dp[l][r] = minOf(dp[l][r], dp[l][p] + dp[p+1][r] + preSum[r]- preSum[l-1])
                }
                l++
                r++
            }

        }
        bw.write("${dp[1][k]}\n")
    }
    bw.flush()
    bw.close()
}