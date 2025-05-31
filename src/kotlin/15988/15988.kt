

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val t = br.readLine().toInt()

    repeat(t) {
        val n = br.readLine().toInt()
        val dp = LongArray(1000001) {0}
        dp[1] = 1
        dp[2] = 2
        dp[3] = 4
        for(i in 4..n) {
            dp[i] = (dp[i-1]+dp[i-2]+dp[i-3])%1000000009
        }
        bw.write("${dp[n]}\n")
    }
    bw.flush()
    bw.close()
}