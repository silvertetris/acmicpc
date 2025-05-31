package kotlin.`22968`

fun main() {
    val br = System.`in`.bufferedReader()
    val bw= System.out.bufferedWriter()
    val dp = LongArray(44) {0}
    dp[0] = 1
    dp[1] = 3
    for(i in 2 .. 43) {
        dp[i] = dp[i-1] + (dp[i-1]-dp[i-2])*2
    }
    val t = br.readLine().toInt()
    repeat(t) {
        val v = br.readLine().toLong()
        for(i in 0 .. 43) {
            if(dp[i]>=v) {
                bw.write("${i+1}\n")
                break
            }
        }
    }
    bw.flush()
    bw.close()
}