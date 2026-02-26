fun main() {
    val br = System.`in`.bufferedReader()
    val (r, c) = br.readLine().split(" ").map { it.toInt() }
    val board = Array(r) { br.readLine() }
    var res = 0
    val visited = Array(r) { BooleanArray(c) }
    val set = mutableSetOf<Char>()
    //좌측 상단 스타트 -> 0,0스타트 에서 격자로 진행하기
    val dx = intArrayOf(1, 0, -1, 0)
    val dy = intArrayOf(0, 1, 0, -1)
    fun dfs(x: Int, y: Int, depth: Int) {
        res = maxOf(res, depth)
        for (i in 0..3) {
            val nx = x + dx[i]
            val ny = y + dy[i]
            if (nx in 0 until r && ny in 0 until c && !visited[nx][ny] && !set.contains(board[nx][ny])) {
                visited[nx][ny] = true
                set.add(board[nx][ny])
                dfs(nx, ny, depth + 1)
                visited[nx][ny] = false
                set.remove(board[nx][ny])
            }
        }
    }
    set.add(board[0][0])
    dfs(0, 0, 1)
    print(res)
}