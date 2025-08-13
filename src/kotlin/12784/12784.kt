fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val t = br.readLine().toInt()

    repeat(t) {
        val (n, m) = br.readLine().split(" ").map { it.toInt() }
        val adj = Array(n + 1) { mutableListOf<Pair<Int, Int>>() }
        repeat(m) {
            val (u, v, w) = br.readLine().split(" ").map { it.toInt() }
            adj[u].add(v to w)
            adj[v].add(u to w)
        }

        val dp = IntArray(n + 1) {0}

        fun dfs(u: Int, p: Int) {
            var sum = 0
            var childCnt = false//자식이 0이거나 있음 -> 있으면 고려 아니면 리프노드
            for ((v, w) in adj[u]) {
                if (v == p) continue
                childCnt= true
                dfs(v, u)
                sum += minOf(dp[v], w)//아래있는 걸로 끊을거냐? 아니면 지금 이 w로 끊을거냐
            }
            dp[u] = if (u != 1 && !childCnt) Int.MAX_VALUE-1_0000 else sum //리프노드면 그 밑으로 못 끊음 -> INF
        }
        dfs(1, 0)
        bw.write("${dp[1]}\n")
    }
    bw.flush()
    bw.close()
}
