package kotlin.`11657`

import java.util.Vector

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    data class Edge(val from: Int, val to: Int, val weight: Int)

    var graph = Vector<Edge>()
    for (i in 0 until m) {
        val (a, b, c) = br.readLine().split(" ").map { it.toInt() }
        graph.add(Edge(a, b, c))
    }
    val INF = Long.MAX_VALUE - 1_000_000
    var dist = LongArray(n + 1) { INF }
    fun bellmanFord(start: Int): Boolean {
        dist[start] = 0 //초기 dist 설정
        repeat(n - 1) {
            for (j in 0 until m) {
                val cur = graph[j]
                if (dist[cur.from] != INF) {
                    val cost = dist[cur.from] + cur.weight
                    if (cost < dist[cur.to]) {
                        dist[cur.to] = cost
                    }
                }
            }
        }
        for (i in 0 until m) {
            val cur = graph[i]
            if (dist[cur.from] != INF && dist[cur.to] > dist[cur.from] + cur.weight) {
                return true
            }
        }
        return false
    }

    val result = bellmanFord(1)
    if (result) {
        bw.write("-1\n")
        bw.flush()
    } else {
        for (i in 2..n) {
            if (dist[i] != INF) {
                bw.write("${dist[i]}\n")
            } else {
                bw.write("-1\n")
            }
            bw.flush()
        }
    }
}
