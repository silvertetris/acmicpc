import java.util.ArrayDeque

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val t = br.readLine().toInt()
    repeat(t) {
        val (n, k) = br.readLine().split(" ").map { it.toInt() }
        val d = listOf(0) + br.readLine().split(" ").map { it.toInt() }
        val ruleAdj = Array(n + 1) { mutableListOf<Int>() }
        val indegree = IntArray(n + 1)

        repeat(k) {
            val (a, b) = br.readLine().split(" ").map { it.toInt() }//a 짓고 b짓기 가능
            ruleAdj[a].add(b)
            indegree[b]++ //차수 증가 -> 이거 지으려면 지어야 하는거 개수
        }
        val mandate = br.readLine().toInt()

        /*
        #1. states/subproblems
        dp[i] = i번째 건물을 짓는데 걸리는 최소 시간
         */
        val dp = IntArray(n + 1)

        val queue = ArrayDeque<Int>()
        for (i in 1..n) {
            if (indegree[i] == 0) {
                //#2. Base Cases
                dp[i] = d[i]
                queue.add(i)
            }
        }

        while (queue.isNotEmpty()) {
            val u = queue.removeFirst()
            for (v in ruleAdj[u]) {
                //#3. transitions
                dp[v] = maxOf(dp[v], dp[u] + d[v])
                // 차수 감소 후 0이면 큐에 추가
                if (--indegree[v] == 0) {
                    queue.add(v)
                }
            }
        }

        //#4. final answer
        bw.write("${dp[mandate]}\n")
    }
    bw.flush()
    bw.close()
}
