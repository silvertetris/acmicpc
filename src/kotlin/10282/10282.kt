import java.util.PriorityQueue

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val t = br.readLine().toInt()
    repeat(t) {
        val (n, d, c) = br.readLine().split(" ").map { it.toInt() }
        val adj = Array(n+1) {mutableListOf<Pair<Int,Int>>()}
        val dist = IntArray(n+1){Int.MAX_VALUE-1000}
        repeat(d) {
            val temp = br.readLine().split(" ").map { it.toInt() }
            adj[temp[1]].add(temp[0] to temp[2])
        }
        dist[c] = 0
        val pq = PriorityQueue<Pair<Int, Int>>(compareBy { it.second })
        pq.add(c to 0)

        while(pq.isNotEmpty()) {
            val (curP, curDist) = pq.poll()
            if(curDist > dist[curP]) continue

            for((u,v) in adj[curP]) {
                val nextD = curDist + v
                if(nextD < dist[u]) {
                    dist[u] = nextD
                    pq.add(u to nextD)
                }
            }
        }
        var count = 0
        var time = 0
        for(i in dist) {
            if(i!=Int.MAX_VALUE-1000) {
                count++
                time = maxOf(time, i)
            }
        }
        bw.write("$count $time\n")
    }
    bw.flush()
    bw.close()
}