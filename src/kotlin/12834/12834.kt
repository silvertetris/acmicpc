package kotlin.`12834`

import java.util.*

fun main() {
    val br = System.`in`.bufferedReader()
    val (n, v, e) = br.readLine().split(" ").map { it.toInt() }
    val (kist, seafood) = br.readLine().split(" ").map { it.toInt() }
    val homes = br.readLine().split(" ").map { it.toInt() }

    val adj = Array(v + 1) { mutableListOf<Pair<Int, Int>>() }
    for (i in 0 until e) {
        val (a, b, l) = br.readLine().split(" ").map { it.toInt() }
        adj[a].add(b to l)
        adj[b].add(a to l)
    }


    fun dijkstra(start: Int, adj: Array<MutableList<Pair<Int, Int>>>, v: Int): IntArray {
        val dist = IntArray(v + 1) { Int.MAX_VALUE }
        val pq = PriorityQueue<Pair<Int, Int>>(compareBy { it.second })

        dist[start] = 0
        pq.add(start to 0)

        while (pq.isNotEmpty()) {
            val (current, currentDist) = pq.poll()

            if (dist[current] < currentDist) continue

            for ((next, weight) in adj[current]) {
                val newDist = currentDist + weight
                if (newDist < dist[next]) {
                    dist[next] = newDist
                    pq.add(next to newDist)
                }
            }
        }

        return dist
    }

    val distFromKist = dijkstra(kist, adj, v)
    val distFromSeafood = dijkstra(seafood, adj, v)

    var sum = 0
    for (home in homes) {
        val distToKist = distFromKist[home]
        val distToSeafood = distFromSeafood[home]

        if (distToKist == Int.MAX_VALUE) {
            sum += -1
        } else {
            sum += distToKist
        }

        if (distToSeafood == Int.MAX_VALUE) {
            sum += -1
        } else {
            sum += distToSeafood
        }
    }

    print(sum)
}
