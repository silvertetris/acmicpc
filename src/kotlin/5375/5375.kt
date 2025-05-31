package kotlin.`5375`

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val t = br.readLine().toInt()
    repeat(t) {
        val (n, m) = br.readLine().split(" ").map { it.toInt() }
        var s = IntArray(m)
        var p = IntArray(m)
        var o = IntArray(m)
        for(i in 0 until m) {
            val(a, b, c) = br.readLine().split(" ").map { it.toInt() }
            s[i] = a
            p[i] = b
            o[i] = c
        }
        /*
        그냥 dp로 하면 문제점 -> p 가 첫인덱스부터 도는데 이러면 비싼걸 먼저 고르게됨
        그렇다면 배송비는 어떻게 고려해?? -> 엄... 일단 p 기준으로 정렬하자.
         */

        val sortedIndices = p.indices.sortedBy { p[it] }
        s = sortedIndices.map { s[it] }.toIntArray()
        p = sortedIndices.map { p[it] }.toIntArray()
        o = sortedIndices.map { o[it] }.toIntArray()


        /*
        #1. states/subproblems
        dp[i] = i 번째 공책을 살 때 최소값
         */
        val dp = LongArray(n + 1) { Int.MAX_VALUE-1_000_000L }

        //#2. Base Cases
        dp[0] = 0
        var answer = Int.MAX_VALUE-1_000_000L //memory exceeds
        //#3. transition
        for (i in 0 until m) {
            for (j in n downTo 0) {
                if (j + s[i]>= n) {
                    answer = minOf(answer, dp[j] + (n - j) * p[i] + o[i]) //나머지 털이
                }
                if (j >= s[i]) {
                    dp[j] = minOf(dp[j], dp[j-s[i]] + p[i]*s[i]+o[i]) //모두 털이
                }
            }
        }
        //#4. final answer
        bw.write("${answer}\n")
    }
    bw.flush()
    bw.close()
}