

import kotlin.math.max
import kotlin.math.min

fun main() {
    val (column, row) = readln().split(" ").map { it.toInt() }
    val arr = Array(column) { CharArray(row) }
    for (i in 0 until column) {
        arr[i] = readln().toCharArray()
    }
    var result = 1
    val temp = min(column, row)

    for (i in temp-1 downTo 1) { //제일 큰 기준부터 1칸까지
        for (j in 0 until row - i) { //옆으로
            for (k in 0 until column - i) { // 아래로
                if (arr[k][j] == arr[k + i][j + i] && arr[k + i][j + i] == arr[k][j + i] && arr[k][j + i] == arr[k + i][j]) {
                    result = max(result, (i + 1) * (i + 1))
                    break
                }
            }
        }
    }
    print(result)
}