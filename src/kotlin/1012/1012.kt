
fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.`out`.bufferedWriter()
    val t = br.readLine().toInt()

    val dx = arrayOf(0, 0, -1, 1)
    val dy = arrayOf(-1, 1, 0, 0)

    repeat(t) {
        val (m, n, k) = br.readLine().split(" ").map { it.toInt() }
        val field = Array(n) { IntArray(m) }
        val visited = Array(n) { BooleanArray(m) }

        repeat(k) {
            val (x, y) = br.readLine().split(" ").map { it.toInt() }
            field[y][x] = 1
        }

        fun dfs(x: Int, y: Int) {
            val stack = mutableListOf(Pair(x, y))
            while (stack.isNotEmpty()) {
                val (cx, cy) = stack.removeLast()
                for (i in 0 until 4) {
                    val nx = cx + dx[i]
                    val ny = cy + dy[i]
                    if (nx in 0 until m && ny in 0 until n && !visited[ny][nx] && field[ny][nx] == 1) {
                        visited[ny][nx] = true
                        stack.add(Pair(nx, ny))
                    }
                }
            }
        }

        var wormCount = 0
        for (i in 0 until n) {
            for (j in 0 until m) {
                if (field[i][j] == 1 && !visited[i][j]) {
                    visited[i][j] = true
                    dfs(j, i)
                    wormCount++
                }
            }
        }

        bw.write("$wormCount\n")
    }

    bw.flush()
    bw.close()
    br.close()
}