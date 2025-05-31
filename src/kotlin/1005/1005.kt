package kotlin.`1005`

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val t = br.readLine().toInt()
    repeat(t) {
        val (n, k) = br.readLine().split(" ").map { it.toInt() } // 건물의 개수, 규칙 총 개수
        val d = listOf(0) + br.readLine().split(" ").map { it.toInt() }.toList()
        val ruleAdj = Array(n + 1) { mutableListOf<Int>() }
        for (i in 0 until k) {
            val (a, b) = br.readLine().split(" ").map { it.toInt() }
            ruleAdj[a].add(b)
        }
        //val dist = IntArray(n+1) {Int.MAX_VALUE-1_000_000}
        val end = br.readLine().toInt()/*
        #1. states/subproblems
        dp[i] = 해당 건물을 짓는데 걸리는 시간
         */
        val dp = IntArray(n + 1) { 0 }
        dp[0] = 0
        dp[1] = d[1]
        for (i in 1..n) {
            var temp = false
            for (j in ruleAdj[i]) {
                if (!temp) {
                    temp = true
                    dp[j]=  d[i]
                }
                dp[j] += d[j]
            }
        }
        bw.write("${dp[end]}\n")
    }
    bw.flush()
    bw.close()
}