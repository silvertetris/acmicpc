fun main() {
    val br = System.`in`.bufferedReader()
    val bw= System.out.bufferedWriter()
    val dp = LongArray(45) {0}
    dp[0] = 0
    dp[1] = 1
    for(i in 2..44) {
        dp[i] = dp[i-1] + dp[i-2] +1
    }
    val t = br.readLine().toInt()
    repeat(t) {
        val v = br.readLine().toLong()
        for(i in 1 .. 43) {
            if(dp[i]>v) {
                bw.write("${i-1}\n")
                break
            }
        }
    }
    bw.flush()
    bw.close()
}