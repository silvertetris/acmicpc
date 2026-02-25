fun main() {
    val br = System.`in`.bufferedReader()
    val board = Array(5) { IntArray(5) }
    for (i in 0 until 5) {
        board[i] = br.readLine().split(" ").map { it.toInt() }.toIntArray()
    }
    val (startX, startY) = br.readLine().split(" ").map { it.toInt() }
    br.close()
    val dx = intArrayOf(1, 0, -1, 0)
    val dy = intArrayOf(0, 1, 0, -1)
    val visited = Array(5) { BooleanArray(5) }

    /*
    깊이를 확인하고, 각 방향에 대해 ++
     */
    var flag = false
    fun dfs(x: Int, y: Int, depth: Int, apple: Int) {
        visited[x][y] = true
        if (depth >= 3) {
            if(apple>=2) {
                flag = true
            }
            return
        }
        for (i in 0..3) {
            val nx = x + dx[i]
            val ny = y + dy[i]
            if (nx in 0..4 && ny in 0..4 && !visited[nx][ny] && board[nx][ny] != -1) {
                if (board[nx][ny] == 1) {
                    dfs(nx, ny, depth + 1, apple + 1)
                } else {
                    dfs(nx, ny, depth + 1, apple)
                }
            }
        }
    }
    if (board[startX][startY] == 1) {
        dfs(startX, startY, 0, 1)
    } else {
        dfs(startX, startY, 0, 0)
    }
    if(flag) {
        print(1)
    } else {
        print(0)
    }
}