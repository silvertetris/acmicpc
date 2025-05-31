package kotlin.`10451`

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.`out`.bufferedWriter()

    val t = br.readLine().toInt()

    repeat(t) {
        val n = br.readLine().toInt()
        val graph = MutableList(n + 1) { mutableListOf<Int>() }
        val arr = br.readLine().split(" ").map { it.toInt() }
        for(i in 1..n) {
            graph[i].add(arr[i - 1])
        }
        val visited = BooleanArray(n + 1)
        var cycleCount = 0

        fun dfs(node: Int) {
            visited[node] = true
            for(i in graph[node].indices) {
                if(!visited[graph[node][i]]) {
                    dfs(graph[node][i])
                }
            }
        }

        for (i in 1..n) {
            if (!visited[i]) { //visited를 탐색함 -> false 면 dfs를 함 -> 사이클인건 모두 true 가 됨 -> 남은건 탐색 안한 false들
                dfs(i)
                cycleCount++
            }
        }

        bw.write("$cycleCount\n")
    }

    bw.flush()
    bw.close()
}
