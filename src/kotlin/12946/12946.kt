fun main() {
    val br = System.`in`.bufferedReader()
    //제일 큰 depth기준으로 찾기? bfs가 나을듯 depth에 따른 count새면 될듯 -> 최대가 3임
    val n =br.readLine().toInt()
    val dx = intArrayOf(-1, -1, 0, 1, 1, 0)
    val dy = intArrayOf(0, 1, 1, 0, -1, -1)
    val arr = Array(n) { BooleanArray (n) {false} }
    for(i in 0 until n) {
        val temp = br.readLine().toCharArray()
        for(j in 0 until n) {
            if(temp[j] == 'X') {
                arr[i][j] = true
            }
        }
    }
    var ans = 0
    val visited = Array(n) { IntArray(n) {-1}}
    fun dfs (x:Int, y:Int, color:Int) {
        visited[x][y] = color
        for(i in 0 until 6) {
            val nx = x+ dx[i]
            val ny = y+ dy[i]
            if(nx in 0 until n && ny in 0 until n && arr[nx][ny]) {
                if(visited[nx][ny] == -1) { // 같을 경우
                    dfs(nx, ny, 1-color)
                    ans = maxOf(ans, 2)
                }
                if(visited[nx][ny] == color) { //아 그니까 인접한곳에 이미 내 색으로 칠해져있는 놈이 있다??
                    //-> 바로 3임
                    ans = 3
                    return
                }
            }
        }
    }
    for(i in 0 until n) {
        for(j in 0 until n) {
            if(visited[i][j] == -1 && arr[i][j]) {
                ans = maxOf( ans, 1)
                dfs(i, j, 0)
            }
        }
    }
    print(ans)
}