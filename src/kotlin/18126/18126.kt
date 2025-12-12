fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    val graph = Array(n + 1) { mutableListOf<Pair<Int, Long>>() }
    repeat(n - 1) {
        val line = br.readLine().split(" ")
        val (u, v) = line[0].toInt() to line[1].toInt()
        val d = line[2].toLong()
        graph[u].add(v to d)
        graph[v].add(u to d)
    }
    val visited = LongArray(n + 1) { -1L }
    visited[1] = 0L
    fun dfs(u: Int) {
        for (nei in graph[u]) {
            if (visited[nei.first] != -1L) {
                continue
            }
            visited[nei.first] =maxOf(visited[nei.first], nei.second + visited[u])
            dfs(nei.first)
        }

    }
    dfs(1)
    print(visited.max())
}