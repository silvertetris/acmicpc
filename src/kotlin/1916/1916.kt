package kotlin.`1916`

import java.util.*

fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    val m = br.readLine().toInt()
    val adj = List(n + 1) { mutableListOf<Pair<Int, Int>>() }
    for (i in 0 until m) {
        val (a, b, c) = br.readLine().split(" ").map { it.toInt() }
        adj[a].add(b to c)
    }
    val (start, end) = br.readLine().split(" ").map { it.toInt() }
    val dist = IntArray(n + 1) { Int.MAX_VALUE-1000000 }
    val visited = BooleanArray(n + 1) { false }
    fun dij(idx: Int) {
        dist[idx] = 0
        val queue: PriorityQueue<Pair<Int, Int>> = PriorityQueue(compareBy { it.second })
        queue.add(idx to 0)
        while (!queue.isEmpty()) {
            val (cur, curDist) = queue.poll()
            if(visited[cur]) continue
            visited[cur] = true
            for ((next, weight) in adj[cur]) {
                if(dist[next] > curDist + weight) {
                    dist[next] = curDist + weight
                    queue.add(next to dist[next])
                }
            }
        }
    }
    dij(start)
    print(dist[end])
}