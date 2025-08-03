fun main() {
    val br = System.`in`.bufferedReader()
    val(n, m) = br.readLine().split(" ").map{it.toInt()}
    val arr = Array(n) {br.readLine().toCharArray()}
    val dx = intArrayOf(1, 0, -1, 0)
    val dy = intArrayOf(0, 1, 0, -1)
    val visited = Array(n) {BooleanArray(m) {false} }
    val cycle = Array(n) {BooleanArray(m) {false} }
    var cnt = 0
    fun dfs(i:Int, j:Int): Boolean {
        visited[i][j] = true
        var nx = 0
        var ny = 0
        when(arr[i][j]) {
            'S'-> {
                nx = i + dx[0]
                ny = j + dy[0]
            }
            'E' -> {
                nx = i + dx[1]
                ny = j + dy[1]
            }
            'N' -> {
                nx = i + dx[2]
                ny = j + dy[2]
            }
            'W' -> {
                nx = i + dx[3]
                ny = j + dy[3]
            }
        }
        if(!visited[nx][ny]) {
            if(dfs(nx, ny) ) {
                cycle[i][j] = true
                return true
            }
        }
        if(!cycle[nx][ny]) {
            cnt ++
            cycle[nx][ny] = true
            cycle[i][j] = true
            return true
        }
        cycle[i][j] = true
        return false
    }
    for(i in 0 until n) {
        for(j in 0 until m) {
            if(!visited[i][j]) {
                dfs(i, j)
            }
        }
    }
    print(cnt)
}