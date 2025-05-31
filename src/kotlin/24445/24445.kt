package kotlin.`24445`

import java.util.*

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.`out`.bufferedWriter()
    val (n, m, r) = br.readLine().split(" ").map { it.toInt() }
    val adj = List(n + 1) { mutableListOf<Int>() }
    for (i in 0 until m) {
        val (u, v) = br.readLine().split(" ").map { it.toInt() }
        adj[u].add(v)
        adj[v].add(u)
    }
    for (i in 0 .. n) {
        adj[i].sortDescending()
    }
    val dist = IntArray(n + 1) { 0 }
    var cnt = 1
    fun bfs(graph: List<MutableList<Int>>) {
        val q: Queue<Int> = LinkedList()
        dist[r] = cnt
        q.add(r)
        while (q.isNotEmpty()) {
            val node = q.poll()
            for (next in graph[node]) {
                if (dist[next] == 0) {
                    dist[next] = ++cnt
                    q.add(next)
                }
            }
        }
    }
    bfs(adj)
    for (i in 1..n) {
        bw.write("${dist[i]}\n")
    }
    bw.flush()
    bw.close()
}