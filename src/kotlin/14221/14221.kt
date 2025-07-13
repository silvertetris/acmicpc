import java.util.PriorityQueue

fun main() {
    val br = System.`in`.bufferedReader()
    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    val adj = Array(n + 1) { mutableListOf<Pair<Int, Int>>() }
    repeat(m) {
        val (u, v, c) = br.readLine().split(" ").map { it.toInt() }
        adj[u].add(v to c)
        adj[v].add(u to c)
    }

    val (p, q) = br.readLine().split(" ").map { it.toInt() }
    val houses = br.readLine().split(" ").map { it.toInt() }.toIntArray()
    val convieny = br.readLine().split(" ").map { it.toInt() }.toIntArray()

    val INF = Int.MAX_VALUE
    val dist = IntArray(n + 1) { INF }
    val pq = PriorityQueue<Pair<Int, Int>>(compareBy { it.second })
    for (c in convieny) { //그냥 얘를 다 전체 출발점으로 잡으면 되잖아
        dist[c] = 0
        pq.add(c to 0)
    }

    while (pq.isNotEmpty()) {
        val (cur, curD) = pq.poll()
        if (curD > dist[cur]) continue
        for ((nxt, cost) in adj[cur]) {
            val nd = curD + cost
            if (nd < dist[nxt]) {
                dist[nxt] = nd
                pq.add(nxt to nd)
            }
        }
    }

    var minDist = INF
    var minIdx = INF
    for (h in houses) {
        val d = dist[h]
        if (d < minDist) {
            minDist = d
            minIdx = h
        } else if (d == minDist && h < minIdx) {
            minIdx = h
        }
    }

    print(minIdx)
}
