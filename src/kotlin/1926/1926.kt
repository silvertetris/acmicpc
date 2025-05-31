

fun main() {
    val br = System.`in`.bufferedReader()
    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    val board = Array(n) { br.readLine().split(" ").map { it.toInt() }.toIntArray() }
    val visited = Array(n) { BooleanArray(m) }

    // 상, 하, 좌, 우
    val dx = arrayOf(-1, 1, 0, 0)
    val dy = arrayOf(0, 0, -1, 1)

    fun dfs(x: Int, y: Int): Int {
        visited[x][y] = true
        var area = 1
        for (dir in 0..3) {
            val nx = x + dx[dir]
            val ny = y + dy[dir]
            if (nx in 0 until n && ny in 0 until m && !visited[nx][ny] && board[nx][ny] == 1) {
                area += dfs(nx, ny)
            }
        }
        return area
    }

    var count = 0
    var maxArea = 0

    for (i in 0 until n) {
        for (j in 0 until m) {
            if (!visited[i][j] && board[i][j] == 1) {
                count++
                val area = dfs(i, j)
                if (area > maxArea) maxArea = area
            }
        }
    }

    println(count)
    println(maxArea)
}