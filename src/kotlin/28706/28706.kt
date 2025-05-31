

fun main() {
    val br = System.`in`.bufferedReader()
    val t = br.readLine().toInt()
    repeat(t) {
        val n = br.readLine().toInt()
        val ops = Array(n) { IntArray(4) }
        repeat(n) { i ->
            val (op1, v1, op2, v2) = br.readLine().split(" ")
            ops[i][0] = if (op1 == "+") 0 else 1 // 0:+, 1:*
            ops[i][1] = v1.toInt()
            ops[i][2] = if (op2 == "+") 0 else 1
            ops[i][3] = v2.toInt()

        }
        val dp = Array(n + 1) { BooleanArray(7) }
        dp[0][1] = true // 시작 K=1
        for (i in 0 until n) {
            for (j in 0..6) {
                if (!dp[i][j]) continue
                // 첫 옵션
                val nj1 = if (ops[i][0] == 0) (j + ops[i][1]) % 7 else (j * ops[i][1]) % 7
                dp[i + 1][nj1] = true
                // 두 번째 옵션
                val nj2 = if (ops[i][2] == 0) (j + ops[i][3]) % 7 else (j * ops[i][3]) % 7
                dp[i + 1][nj2] = true
            }
        }
        if (dp[n][0]) println("LUCKY") else println("UNLUCKY")
    }
}