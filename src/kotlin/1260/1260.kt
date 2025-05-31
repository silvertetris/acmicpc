package kotlin.`1260`

import java.util.*

fun main() {
    val br = System.`in`.bufferedReader()
    val (n, m, start) = br.readLine().split(" ").map { it.toInt() }
    val adj = Array(n + 1) { mutableListOf<Int>() }
    for (i in 0 until m) {
        val (a, b) = br.readLine().split(" ").map { it.toInt() }
        adj[a].add(b)
        adj[b].add(a)
        adj[a].sort()
        adj[b].sort()
    }
    val dist = IntArray(n + 1) { -1 }
    val visited = BooleanArray(n + 1) { false }
    val dfsResult = mutableListOf<Int>()
    val bfsResult = mutableListOf<Int>()
    fun dfs(v: Int) {
        visited[v] = true
        dfsResult.add(v)
        for (i in adj[v]) {
            if (!visited[i]) {
                dfs(i)
            }
        }
    }

    fun bfs(graph: Array<MutableList<Int>>) {
        val q: Queue<Int> = LinkedList()
        dist[start] = 0
        q.add(start)
        while (q.isNotEmpty()) {
            val node = q.poll()
            bfsResult.add(node)
            for (neighbor in graph[node]) {
                if (dist[neighbor] == -1) {
                    dist[neighbor] = 1
                    q.add(neighbor)
                }
            }
        }
    }
    dfs(start)
    bfs(adj)
    println(dfsResult.joinToString(" "))
    println(bfsResult.joinToString(" "))
}