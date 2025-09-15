fun main() {
    val br = System.`in`.bufferedReader()
    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    val arr = Array(n) { IntArray(m) { 0 } }
    for (i in 0 until n) {
        arr[i] = br.readLine().split(" ").map { it.toInt() }.toIntArray()
    }
    /*
    #1. states / subproblems
    dp[i][j] = i, j indices 에서 maxOf -> value 찾기
     */
    val INF = -10000000001L
    val udp = Array(n + 1) { LongArray(m + 1) { INF } }//좌하에서 우상
    val ddp = Array(n + 1) { LongArray(m + 1) { INF } }//우하에서 좌상
    //#3. transition
    for (i in n - 1 downTo 0) {
        for (j in 1..m) {
            if (i == n - 1 && j == 1) {
                //#2. Base Cases
                udp[i + 1][j] = arr[i][j - 1].toLong()
                continue
            }
            udp[i + 1][j] =
                maxOf(if (i + 2 <= n) udp[i + 2][j] else INF, if (j - 1 >= 1) udp[i + 1][j - 1] else INF) +
                        arr[i][j - 1]
        }
    }//시간초과 걸리면 통합
    for (i in n - 1 downTo 0) {
        for (j in m - 1 downTo 0) {
            if (i == n - 1 && j == m - 1) {
                ddp[i + 1][j + 1] = arr[i][j].toLong()
                continue
            }
            ddp[i + 1][j + 1] =
                maxOf(if (i + 2 <= n) ddp[i + 2][j + 1] else INF, if (j + 2 <= m) ddp[i + 1][j + 2] else INF) +
                        arr[i][j]
        }
    }
    //#4.final answer
    var max = INF
    for (i in 1..n) {
        for (j in 1..m) {
            max = maxOf(max, udp[i][j] + ddp[i][j])
        }
    }
    print(max)
}
