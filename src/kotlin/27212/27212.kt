

fun main() {
    val br = System.`in`.bufferedReader()
    val( n, m, c) = br.readLine().split(" ").map { it.toInt() }
    val w = Array(c+1) {LongArray(c+1) }
    for(i in 1 .. c) {
        w[i] =longArrayOf(0L) + br.readLine().split(" ").map{it.toLong()}.toLongArray()
    }
    val aChar = intArrayOf(0)+br.readLine().split(" ").map{it.toInt()}.toIntArray()
    val bChar = intArrayOf(0)+br.readLine().split(" ").map{it.toInt()}.toIntArray()
    /*
    #1. states/ subproblems
    dp[i][j] = i 번째 학생이랑 j 번째 학생이랑 악수 할때 최대 인기도 값
     */
    val dp = Array(n+1) {LongArray(m+1) {0L} }

    //#3. transitions
    for(i in 1.. n) {
        for(j in 1.. m) { //조건 제약 넣어야함

            dp[i][j] = maxOf(dp[i][j-1], dp[i-1][j])

            dp[i][j] = maxOf(dp[i][j], dp[i-1][j-1]+w[aChar[i]][bChar[j]])
        }
    }
    //#4. final answer
    print(dp[n][m])

}