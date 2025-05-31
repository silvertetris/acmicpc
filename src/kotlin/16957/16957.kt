

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val (r, c) = br.readLine().split(" ").map { it.toInt() }
    val chess = Array(r) { IntArray(c) }
    val dx = intArrayOf(-1, 0, 1, 1, 1, 0, -1, -1)//top-left to cw 방향 (격자 그래프 탐색)
    val dy = intArrayOf(1, 1, 1, 0, -1, -1, -1, 0)

    for (i in 0 until r) {
        chess[i] = br.readLine().split(" ").map { it.toInt() }.toIntArray()
    }


    val adj = Array(r) { Array(c) { Pair(-1, -1) } }
    //memoization
    val mem = Array(r) { Array(c) { -1 to -1} }


    for (i in 0 until r) { //각 칸에 대해서 어디로 갈지 위치 그래프 형성
        for (j in 0 until c) {
            val curr = chess[i][j]
            var minNextVal = Int.MAX_VALUE
            var nextX = -1
            var nextY = -1
            for (d in 0 until 8) {
                val nx = i + dx[d]
                val ny = j + dy[d]
                    if (nx in 0 until r && ny in 0 until c && chess[nx][ny] <= curr) {
                        if (chess[nx][ny] < minNextVal) {
                            minNextVal = chess[nx][ny]
                            nextX = nx
                            nextY = ny
                        }
                    }
                }
            if (nextX == -1) {
                adj[i][j] = Pair(-1, -1)
            } else {
                adj[i][j] = Pair(nextX, nextY)
            }
        }
    }


    fun dfs(x: Int, y: Int): Pair<Int, Int> { //memoization dfs
        if (mem[x][y] != -1 to -1) {
            return mem[x][y]
        }
        val (nx, ny) = adj[x][y]
        if (nx == -1 && ny == -1) {
            mem[x][y] = Pair(x, y)
        } else {
            mem[x][y] = dfs(nx, ny)
        }
        return mem[x][y]
    }

    val result = Array(r) { LongArray(c) { 0L } }
    for (i in 0 until r) {
        for (j in 0 until c) {
            val (x, y) = dfs(i, j)
            result[x][y] += 1L
        }
    }

    for (i in 0 until r) {
        bw.write("${result[i].joinToString(" ")}\n")
    }
    bw.flush()
    bw.close()
}