package kotlin.`10710`

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    val d = IntArray(n)
    val c = IntArray(m)
    for (i in 0 until n) {
        d[i] = br.readLine().toInt()
    }
    for (i in 0 until m) {
        c[i] = br.readLine().toInt()
    }
    /*
    #1. states/ subproblems
    dp[i][j] = i일차에 j 도시 일 때
     */
    val dp = Array(m + 1) { IntArray(n + 1) { Int.MAX_VALUE } }
    //#2. Base Cases: 0일차에 0도시니까 일단 출발을 안함
    dp[0][0] = 0

    //#3. transition
    for (i in 1..m) {
        for (j in 0..n) {
            dp[i][j] = dp[i - 1][j] // 이게 그냥 대기하는 경우
            if (j > 0 && dp[i - 1][j - 1] != Int.MAX_VALUE) { //두번째 조건 안넣으면 아래 두번째 값 계산하다가 터짐
                dp[i][j] = minOf(dp[i][j], dp[i - 1][j - 1] + c[i - 1] * d[j - 1]) // 1. 그대로 있냐 2. 그 날씨에 건널 꺼냐
            }
        }
    }
    //#4. final answer
    bw.write("${dp[m][n]}")
    bw.flush()
    bw.close()
}