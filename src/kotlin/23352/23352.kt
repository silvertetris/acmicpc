import java.util.LinkedList

fun main() {
    val br = System.`in`.bufferedReader()
    val dx = intArrayOf(0, 1, 0, -1)
    val dy = intArrayOf(1, 0, -1, 0)
    //0은 길이 아님
    //어떤 특정 지점에 대해 모든 점들의 최단 거리 -> 그 지점 값 + 엔드 값  저장
    //50*50 이니까 시간초과 걱정 X
    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    val map = Array(n) { br.readLine().split(" ").map { it.toInt() }.toIntArray() }
    fun bfs(r: Int, c: Int): Pair<Int, Int> {
        val dist = Array(n) { IntArray(m) { -1 } }
        val queue = LinkedList<Pair<Int, Int>>()
        var maxdist = 0
        var maxVal = 0
        queue.add(r to c)
        dist[r][c] = 0
        while (queue.isNotEmpty()) {
            val (curR, curC) = queue.poll()
            for (i in 0 until 4) {
                val nR = curR + dy[i]
                val nC = curC + dx[i]

                if (nR in 0 until n && nC in 0 until m && map[nR][nC] != 0 && dist[nR][nC] == -1) {
                    dist[nR][nC] = dist[curR][curC] + 1
                    queue.add(nR to nC)
                    if (maxdist < dist[nR][nC]) {
                        maxdist = dist[nR][nC]
                        maxVal = map[r][c] + map[nR][nC]
                    } else if (maxdist == dist[nR][nC]) {
                        maxVal = maxOf(maxVal, map[r][c] + map[nR][nC])
                    }
                }
            }
        }
        return maxdist to maxVal
    }

    fun check(r: Int, c: Int): Boolean {
        return r !in 0 until n || c !in 0 until m
    }

    var answer = 0
    var maxdist = 0
    for (i in 0 until n) {
        for (j in 0 until m) {
            if (map[i][j] == 0) continue
            if ((check(i - 1, j) and check(i + 1, j) && map[i - 1][j] != 0 && map[i + 1][j] != 0)) continue
            if ((check(i, j - 1) and check(i, j + 1) && map[i][j - 1] != 0 && map[i][j + 1] != 0)) continue
            val temp = bfs(i, j)
            if (maxdist < temp.first) {
                maxdist = temp.first
                answer = temp.second
            } else if (maxdist == temp.first) {
                answer = maxOf(answer, temp.second)
            }
        }
    }
    print(answer)
}