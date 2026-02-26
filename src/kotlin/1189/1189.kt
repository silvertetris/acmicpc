fun main() {
    val br = System.`in`.bufferedReader()
    val (r, c, k) = br.readLine().split(" ").map { it.toInt() }
    val board = Array(r) { br.readLine() }

    /*
    dp -> 역방향이 있어서 불가능
    5*5 범위기 때문에 그리디로도 가능함
    dfs -> 0, 0 부터 r-1, c-1 까지
     */
    val visited = Array(r) {BooleanArray(c) { false } }
    visited[r-1][0] = true
    val dx = intArrayOf(1, 0, -1, 0)
    val dy = intArrayOf(0, 1, 0, -1)
    var res = 0
    fun dfs(x: Int, y: Int, depth: Int) {
        if (x == 0 && y == c-1&& depth == k) {
            res++
        }
        for (i in 0..3) {
            val nx = x + dx[i]
            val ny = y + dy[i]
            if (nx in 0 until r && ny in 0 until c && board[nx][ny] != 'T' && !visited[nx][ny]) {
                visited[nx][ny] = true
                dfs(nx, ny, depth + 1)
                visited[nx][ny] = false
            }
        }
    }
    dfs(r-1, 0 ,1)
    print(res)
}