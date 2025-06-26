fun main() {
    val br = System.`in`.bufferedReader()
    val (n, m, k) = br.readLine().split(" ").map { it.toInt() }
    val x = IntArray(n)
    val y = IntArray(n)
    for (i in 0 until n) {
        val temp = br.readLine().split(" ").map { it.toInt() }
        x[i] = temp[0]
        y[i] = temp[1]
    }
    /*
    #1. states / subproblems
    dp[j][kk] = 치즈버거 j개, 감자튀김 kk개 남았을 때
                최대 주문 횟수
    */
    //#2. base Cases
    val dp = Array(m + 1) { IntArray(k + 1) { 0 } }

    //#3. transition — 0-1 냅색이므로 뒤에서부터 순회
    for (i in 0 until n) {
        // 치즈버거 x[i], 감자튀김 y[i]를 한 번 고를 때
        for (j in m downTo x[i]) {
            for (kk in k downTo y[i]) {
                dp[j][kk] = maxOf(
                    dp[j][kk],
                    dp[j - x[i]][kk - y[i]] + 1
                )
            }
        }
    }

    //#4. final answer
    print(dp[m][k])
}
