import java.util.PriorityQueue

fun main() {
    val br = System.`in`.bufferedReader()
    val (n, k) = br.readLine().split(" ").map { it.toInt() }
    val adj = Array(n) { IntArray(n) }
    for (i in 0 until n) { //어차피 대칭 행렬 굳이 양방향 코드 x
        val temp = br.readLine().toCharArray()
        for (j in 0 until n) {
            adj[i][j] = temp[j] - '0'
        }
    }
    val dist = IntArray(n) {Int.MAX_VALUE-100}
    val pq = PriorityQueue<Pair<Int, Int>>(compareBy { it.second })
    val start = 0
    dist[start] = 0
    pq.add(Pair(start, 0))


}