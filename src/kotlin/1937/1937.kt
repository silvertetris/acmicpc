

fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    val forest = Array(n) { br.readLine().split(" ").map { it.toInt() }.toIntArray() }
    val dp = Array(n) { IntArray(n) { 0 } }

    val dx = intArrayOf(-1, 1, 0, 0)
    val dy = intArrayOf(0, 0, -1, 1)

    fun dfs(x: Int, y: Int): Int {
        if (dp[x][y] != 0) return dp[x][y]
        dp[x][y] = 1 // 자기자신은 무조건 한 칸
        for (dir in 0 until 4) {
            val nx = x + dx[dir]
            val ny = y + dy[dir]
            if (nx in 0 until n && ny in 0 until n && forest[nx][ny] > forest[x][y]) {
                dp[x][y] = maxOf(dp[x][y], dfs(nx, ny) + 1)
            }
        }
        return dp[x][y]
    }

    var result = 0
    for (i in 0 until n) {
        for (j in 0 until n) {
            result = maxOf(result, dfs(i, j))
        }
    }
    print(result)
}