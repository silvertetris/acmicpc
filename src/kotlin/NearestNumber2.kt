package kotlin

fun main() {
    val n = readln().toInt()
    val howMany = Array(n) { Array(n) { 0 } }
    val arr = Array(n) { Array(n) { 0 } }
    var visited = Array(n) { Array(n) { 0 } }
    var resultArr = arr
    for (i in 0 until n) {
        arr[i] = readln().split(" ").map { it.toInt() }.toTypedArray()
    }

    fun dp(x: Int, y: Int): Pair<Int, Int> { //first:인근 second: value
            if (visited[x][y] == 1) {
                return Pair(0, 0)
            }
            if (arr[x][y] != 0) {
                visited[x][y] = 1
                return Pair(1, arr[x][y])
            }
            var cnt = 0
            visited[x][y] = 1
            if (x == 0 && y == 0) {
                howMany[x][y] = dp(x + 1, y).first + dp(x, y + 1).first
                cnt += dp(x + 1, y).second + dp(x, y + 1).second
            } else if (x == n - 1 && y == n - 1) {
                howMany[x][y] = dp(x - 1, y).first + dp(x, y - 1).first
                cnt += dp(x - 1, y).second + dp(x, y - 1).second
            } else if(y==0 && x == n-1) {
                howMany[x][y] = dp(x, y+1).first + dp(x-1, y).first
                cnt += dp(x, y+1).second+dp(x-1, y).second
            } else if(x==0 && y==n-1) {
                howMany[x][y] = dp(x, y-1).first + dp(x+1, y).first
                cnt += dp(x, y-1).second + dp(x+1, y).second
            }
            else if (y < n - 1 && x == 0 && y != 0) {
                howMany[x][y] = dp(x + 1, y).first + dp(x, y + 1).first + dp(x, y - 1).first
                cnt += dp(x + 1, y).second + dp(x, y + 1).second + dp(x, y - 1).second
            } else if (y == 0 && x < n - 1 && x != 0) {
                howMany[x][y] = dp(x + 1, y).first + dp(x, y + 1).first + dp(x - 1, y).first
                cnt += dp(x + 1, y).second + dp(x, y + 1).second + dp(x - 1, y).second
            } else if (x == n - 1 && y != n - 1 && y != 0) {
                howMany[x][y] = dp(x - 1, y).first + dp(x, y - 1).first + dp(x, y + 1).first
                cnt += dp(x - 1, y).second + dp(x, y - 1).second + dp(x, y + 1).second
            } else if (x != n - 1 && y == n - 1 && x != 0) {
                howMany[x][y] = dp(x - 1, y).first + dp(x, y - 1).first + dp(x + 1, y).first
                cnt += dp(x - 1, y).second + dp(x, y - 1).second + dp(x + 1, y).second
            } else {
                howMany[x][y] = dp(x + 1, y).first + dp(x - 1, y).first + dp(x, y + 1).first + dp(x, y - 1).first
                cnt += dp(x + 1, y).second + dp(x - 1, y).second + dp(x, y + 1).second + dp(x, y - 1).second
            }
            if (howMany[x][y] == 1) {
                resultArr[x][y] = cnt
            }
            return Pair(0, arr[x][y])
    }
    for (i in 0 until n) {
        for (j in 0 until n) {
            dp(i, j)
            visited = Array(n) { Array(n) { 0 } }
        }
    }
    for (i in 0 until n) {
        println(resultArr[i].joinToString(" "))
    }
}