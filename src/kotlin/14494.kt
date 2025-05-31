

fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    var arr: Array<Array<Long>> = Array(2000) { Array(2000) { 0L } }

    fun dp(x: Int, y: Int): Long {
        if (x == 1 || y == 1) {
            return 1
        }
        else if (arr[x][y] != 0L) {
            return arr[x][y]
        } else {
            arr[x][y] = dp(x - 1, y)%1000000007 + dp(x, y - 1)%1000000007 + dp(x - 1, y - 1)%1000000007
            return arr[x][y]
        }
    }

    print(dp(n, m)%1000000007)
}