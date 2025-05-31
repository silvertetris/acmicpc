

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()

    val n = br.readLine().toInt()
    val r = br.readLine().split(" ").map { it.toInt() }
    /*
    #1. states/subproblems
    dp[i][0] = 선택하지 않을 경우
    dp[i][1] = 선택할 경우
     */
    //#2. Base Cases
    val dp = Array(n) { Array<Long>(2) { 0 } }
    dp[0][0] = 0
    dp[0][1] = r[0].toLong()
    //#3. transition
    for(i in 1 until n) {
        dp[i][0] = dp[i-1][1]
        dp[i][1] = minOf(dp[i-1][0], dp[i-1][1]) + r[i]
    }

    bw.write("${minOf(dp[n-1][0], dp[n-1][1])}")
    bw.flush()
    bw.close()
}