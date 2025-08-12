fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val dx = intArrayOf(1, 0, -1, 0)
    val dy = intArrayOf(0, 1, 0, -1)
    val t = br.readLine().toInt()
    repeat(t) {
        val(m, n, k) = br.readLine().split(" ").map { it.toInt() }
        val map = Array(n) {IntArray(m) {0} }
        repeat(k) {
            val(u, v) = br.readLine().split(" ").map { it.toInt() }
            map[v][u] = 1
        }
        val visited = Array(n) { BooleanArray(m) {false} }
        fun dfs(x:Int, y:Int) {
            visited[x][y] = true
            for(i in 0 until 4) {
                val nx= x+dx[i]
                val ny= y+dy[i]
                if(nx in 0 until n && ny in 0 until m && !visited[nx][ny] && map[nx][ny] == 1) {
                    dfs(nx, ny)
                }
            }
        }
        var cnt = 0
        for(i in 0 until n) {
            for(j in 0 until m) {
                if(!visited[i][j] &&map[i][j] ==1 ) {
                    cnt++
                    dfs(i, j)
                }
            }
        }
        bw.write("$cnt\n")
    }
    bw.flush()
    bw.close()
    br.close()
}