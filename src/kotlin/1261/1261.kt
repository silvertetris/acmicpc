import java.util.LinkedList
import java.util.PriorityQueue

fun main() {
    val br = System.`in`.bufferedReader()
    val (m, n) = br.readLine().split(" ").map { it.toInt() }
    val dx = intArrayOf(0, 1, 0, -1)
    val dy = intArrayOf(1, 0, -1, 0)
    val arr = Array(n) {""}
    for (i in 0 until n) {
        arr[i] = br.readLine()
    }
    br.close()
    val dist = Array(n) { IntArray(m) { Int.MAX_VALUE - 100_000 } }
    fun dijkstra(start: Int, end: Int) {
        val queue = PriorityQueue<Triple<Int, Int, Int>> (compareBy { it.first })
        queue.add(Triple(0, start, end))
        dist[start][end] = 0
        while (queue.isNotEmpty()) {
            val a = queue.poll()
            val curRow = a.second
            val curCol = a.third
            for (i in 0 until 4) {
                val nRow = curRow + dy[i]
                val nCol = curCol + dx[i]
                if (nRow in 0 until n && nCol in 0 until m && dist[nRow][nCol] > dist[curRow][curCol] + (arr[curRow][curCol]-'0')) {
                    dist[nRow][nCol] = dist[curRow][curCol] + (arr[curRow][curCol]-'0')
                    queue.add(Triple(dist[nRow][nCol],nRow, nCol))
                }
            }
        }
    }
    dijkstra(0, 0)
    print(dist[n - 1][m - 1])
}