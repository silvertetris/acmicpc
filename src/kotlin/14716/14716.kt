import java.util.LinkedList
import java.util.Queue

fun main() {
    val br = System.`in`.bufferedReader()
    val (m, n) = br.readLine().split(" ").map { it.toInt() }
    val arr = Array(m) { IntArray(n)}
    for(i in 0 until m) {
        arr[i] = br.readLine().split(" ").map { it.toInt() }.toIntArray()
    }

    br.close()

    val dx = intArrayOf(0, 1, 1, 1, 0, -1, -1, -1)
    val dy = intArrayOf(1, 1, 0, -1, -1, -1, 0, 1)

    val visited = Array(m) {BooleanArray(n) {false} }
    fun bfs (x: Int, y: Int) {
        val q: Queue<Pair<Int, Int>> = LinkedList()
        visited[x][y] = true
        q.add(x to y)
        while(q.isNotEmpty()) {
            val( curX, curY) = q.poll()
            for(i in 0 until 8) {
                val nx = curX + dx[i]
                val ny = curY + dy[i]
                if(nx in 0 until m && ny in 0 until n && !visited[nx][ny] && arr[nx][ny] == 1) {
                    q.add(nx to ny)
                    visited[nx][ny] = true
                }
            }
        }
    }
    var answer = 0
    for(i in 0 until m) {
        for(j in 0 until n) {
            if(!visited[i][j]&&arr[i][j]==1) {
                answer ++
                bfs(i, j)
            }
        }
    }
    print(answer)
}