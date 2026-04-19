import java.util.PriorityQueue
import java.util.StringTokenizer

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val n = br.readLine().toInt()
    val m = br.readLine().toInt()
    val INF = Int.MAX_VALUE-100_000
    val dist = IntArray(n+1) {INF}
    val arr = Array(n+1) {mutableListOf<Pair<Int, Int>>()}
    /*
    같은 정점을 또 지나는 경우는 없음
    그럼 idx가 start면 끝
    메모리 초과 위험
    -> 초과나면 result 리스트 없애야할듯
     */
    val parent = IntArray(n+1) {it}
    repeat(m) {
        val str = StringTokenizer(br.readLine())
        arr[str.nextToken().toInt()].add(str.nextToken().toInt() to str.nextToken().toInt())
    }
    val (start, end) = br.readLine().split(" ").map{it.toInt()}
    val pq = PriorityQueue<Pair<Int, Int>>(compareBy { it.second })
    dist[start]=0
    pq.add(start to 0)

    while(pq.isNotEmpty()) {
        val(cur, curDist) = pq.poll()
        if(dist[cur]<curDist) continue
        for((nextPos, nextDist) in arr[cur]) {
            val cost = curDist+nextDist
            if(cost < dist[nextPos]) {
                dist[nextPos] = cost
                parent[nextPos] = cur
                pq.add(nextPos to cost)
            }
        }
    }
    bw.write("${dist[end]}\n")
    val result = mutableListOf<Int>()
    var idx = end
    while(true) {
        result.add(idx)
        if(idx== start) break
        idx=parent[idx]
    }
    bw.write("${result.size}\n")
    /*
    1000
3
1 1000 1000
1 1000 5000
1 1000 500
1 1000
     */
    bw.write(result.reversed().joinToString(" "))
    bw.flush()
}