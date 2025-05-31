

fun main(){
    val br= System.`in`.bufferedReader()
    val bw = System.`out`.bufferedWriter()
    val t = br.readLine().toInt()
    val dp = LongArray(100001) { 0 }
    dp[1] = 1
    dp[2] = 2
    dp[3] = 2
    dp[4] = 3
    dp[5] = 3
    dp[6] = 6
    for(i in 7.. 100000) {
        dp[i] = (dp[i-2]+dp[i-4]+dp[i-6]) %1_000_000_009
    }
    repeat(t) {
        val n = br.readLine().toInt()
        bw.write("${dp[n]}\n")
    }
    bw.flush()
    bw.close()
}