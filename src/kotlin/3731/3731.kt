fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.`out`.bufferedWriter()
    while (true) {
        val temp = br.readLine()
        if (temp.isBlank()) break
        val n = temp.toInt()
        val rowSum = Array(n) { IntArray(n) { 0 } }
        val colSum = Array(n) { IntArray(n) { 0 } }
        val arr = Array(n) { IntArray(n) { 0 } }
        for (i in 0 until n) {
            arr[i] = br.readLine().split(" ").map { it.toInt() }.toIntArray()
        }
        for (i in 0 until n) {
            rowSum[i][0] = arr[i][0]
            colSum[0][i] = arr[0][i]
        }
        for (i in 1 until n) {
            for (j in 1 until n) {
                rowSum[i][j] = arr[i][j] + rowSum[i][j - 1]
                colSum[j][i] = arr[j][i] + colSum[j - 1][i]
            }
        }
        /*
        #1. states / subproblems
        dp[i][j] = i, j 승리 여부 -> 가능성이 있는지
         */
        val dp = Array(n + 1) { BooleanArray(n + 1) { false } }
        dp[0][0] = false

        for (k in 1..n) {
            for (m in 1..n) {
                var win = false

                val sumLastRow = rowSum[k - 1][m - 1]
                if (sumLastRow % 2 == 0 && !dp[k - 1][m]) {
                    win = true
                }

                if (!win) {
                    val sumLastCol = colSum[k - 1][m - 1]
                    if (sumLastCol % 2 == 0 && !dp[k][m - 1]) {
                        win = true
                    }
                }

                dp[k][m] = win
            }
        }
        bw.write(if (dp[n][n]) "W\n" else "L\n")
    }
    bw.flush()
    bw.close()
}