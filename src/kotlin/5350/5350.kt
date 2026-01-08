fun main() {
    val br = System.`in`.bufferedReader()
    val bw= System.out.bufferedWriter()
    val t = br.readLine().toInt()
    repeat(t) {
        val(n, w) = br.readLine().split(" ").map{it.toInt()}
        val weight = IntArray(n)
        val value = IntArray(n)
        for(i in 0 until n) {
            val (u, v) = br.readLine().split(" ").map{it.toInt()}
            weight[i] = u
            value[i] = v
        }

        val dp = Array(n+1) {IntArray(w+1) {0} }
        //dp[i][j] = i index에서 무게가 w일때 최대 가치
        for(i in 1.. n) {
            for(j in 0.. w) {
                dp[i][j] = dp[i-1][j]
                if(j-weight[i-1]>=0) {
                    dp[i][j] = maxOf(dp[i][j], dp[i-1][j-weight[i-1]]+value[i-1])
                }
            }
        }
        bw.write("${dp[n][w]}\n")
    }
    bw.flush()
}