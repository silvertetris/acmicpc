fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.`out`.bufferedWriter()
    val t = br.readLine().toInt()
    val dx = intArrayOf(1, 0, -1, 0)
    val dy = intArrayOf(0, 1, 0, -1)
    repeat(t) {
        val (h, w) = br.readLine().split(" ").map { it.toInt() }
        val arr= Array(h) {br.readLine()}
        val visited = Array(h) {BooleanArray(w) {false} }
        fun dfs(x:Int, y:Int) {
            visited[x][y] = true
            for(i in 0 until 4) {
                val nx= x+dx[i]
                val ny= y+dy[i]
                if(nx in 0 until h && ny in 0 until w && !visited[nx][ny] && arr[nx][ny] == '#') {
                    dfs(nx, ny)
                }
            }
        }
        var cnt = 0
        for(i in 0 until h) {
            for(j in 0 until w) {
                if(!visited[i][j] && arr[i][j] == '#') {
                    dfs(i, j)
                    cnt++
                }
            }
        }
        bw.write("$cnt\n")
    }
    bw.flush()
    bw.close()
}