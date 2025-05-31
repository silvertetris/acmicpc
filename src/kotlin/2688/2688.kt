package kotlin.`2688`

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val t = br.readLine().toInt()

    repeat(t) {
        val n = br.readLine().toInt()
        val dp = Array(66) {LongArray(10) {0} }
        for(i in 0 ..9 ) {
            dp[0][i] = 1
        }
        for(i in 1 until n) {
            for(j in 0..9) {
                for(k in 0 ..j) {
                    dp[i][j] +=dp[i-1][k]
                }
            }
        }
        var result = 0L
        for(i in 0..9) {
            result+=dp[n-1][i]
        }
        bw.write("${result}\n")
    }
    bw.flush()
    bw.close()
}