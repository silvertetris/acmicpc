fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val t = br.readLine().toInt()
    val dp = IntArray(191230) { 0 }
    dp[0] = 0
    dp[1] = 1
    dp[2] = 2
    for(i in 3..191229) {
        dp[i] = (dp[i - 1] + dp[i - 2])%1_000_000_007
    }


    repeat(t) {
        val n = br.readLine().toInt()
        bw.write("${dp[n]}\n")
    }
    bw.flush()
}