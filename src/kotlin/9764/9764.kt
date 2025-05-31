package kotlin.`9764`

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val t = br.readLine().toInt()
    val MOD = 100999
    repeat(t) {
        val n = br.readLine().toInt()
        val dp = Array(n+1) {LongArray(n+1)}
        //Base Case
        dp[0][0]=1
        for (k in 1..n) {
            for (num in 0..n) { //transitions
                dp[num][k] = dp[num][k - 1]  // Exclude k
                if (num >= k) {
                    dp[num][k] = (dp[num][k] + dp[num - k][k - 1]) % MOD  // Include k
                }
            }
        }
        //final answer
        bw.write("${dp[n][n]}\n")
    }
    bw.flush()
    bw.close()
}