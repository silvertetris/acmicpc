package kotlin.`1504`

import java.util.*


fun main() {
    val br = System.`in`.bufferedReader()
    val (n, e) = br.readLine().split(" ").map { it.toInt() }
    val adj = Array(n + 1) { mutableListOf<Pair<Int, Int>>() }

    fun dijkstra(start: Int, adj: Array<MutableList<Pair<Int, Int>>>, n: Int): IntArray {
        val dist = IntArray(n + 1) { Int.MAX_VALUE }
        val pq = PriorityQueue<Pair<Int, Int>>(compareBy { it.second })
        dist[start] = 0
        pq.add(Pair(start, 0))

        while (pq.isNotEmpty()) {
            val (current, currentDist) = pq.poll()
            if (dist[current] < currentDist) continue

            for ((next, weight) in adj[current]) {
                val newDist = currentDist + weight
                if (newDist < dist[next]) {
                    dist[next] = newDist
                    pq.add(Pair(next, newDist))
                }
            }
        }
        return dist
    }
    repeat(e) {
        val (a, b, c) = br.readLine().split(" ").map { it.toInt() }
        adj[a].add(Pair(b, c))
        adj[b].add(Pair(a, c))
    }

    val (v1, v2) = br.readLine().split(" ").map { it.toInt() }

    val distFrom1 = dijkstra(1, adj, n)
    val distFromV1 = dijkstra(v1, adj, n)
    val distFromV2 = dijkstra(v2, adj, n)

    val path1 = distFrom1[v1].toLong() + distFromV1[v2] + distFromV2[n]
    val path2 = distFrom1[v2].toLong() + distFromV2[v1] + distFromV1[n]

    val result = minOf(path1, path2)

    println(if (result >= Int.MAX_VALUE || result<0) -1 else result)
}
