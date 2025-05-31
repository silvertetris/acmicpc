

fun main() {
    val n = readln().toInt()
    val arr: Array<Array<Int>> = Array<Array<Int>>(n) { Array(n) { 0 } }
    for (i in 0 until n) {
        arr[i] = readln().split(" ").map { it.toInt() }.toTypedArray()
    }
    val visited: Array<Array<Int>> = Array(n) { Array(n) { 0 } }
    var cnt = 0
    fun bfs(value: Int, x: Int, y: Int) {
        if(visited[x][y]!=0) return
        if (value == -1) {
            cnt = 1
            return
        }
        visited[x][y]=1
        var moveX = x + value
        var moveY = y + value
        if (moveX <= n - 1) {
            bfs(arr[moveX][y], moveX, y)
        }
        if (moveY <= n - 1) {
            bfs(arr[x][moveY], x, moveY)
        }
        return
    }
    bfs(arr[0][0], 0, 0)
    if (cnt == 1) {
        print("HaruHaru")
    } else {
        print("Hing")
    }
}