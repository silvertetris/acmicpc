

import java.util.*

fun main() {
    var result: ArrayList<Array<Int>> = ArrayList<Array<Int>>()
    val sc = Scanner(System.`in`)
    val n = sc.nextInt()
    for (i in 0 until n) {
        sc.nextLine()
        val cnt = sc.nextInt()
        val arr: Array<Int> = Array<Int>(2 * cnt) { 0 }
        var resultArr: Array<Int> = Array<Int>(cnt) { 0 }
        for (i in 0 until 2 * cnt) {
            arr[i] = sc.nextInt()
        }
        arr.sortDescending()
        var temp = 0
        for (j in 0 until 2 * cnt) {
            if (arr[j] % 4 != 0 || arr[j] < 4) {
                continue
            }
            if (arr.contains((arr[j] / 4) * 3)) {
                resultArr[temp] = (arr[j] / 4) * 3
                temp++
            }
            if (temp == cnt) break
        }

        result.add(resultArr)
    }
    for (i in 0 until result.size) {
        print("Case #${i + 1}:")
        result[i].sort()
        var str = ""
        for (j in 0 until result[i].size) {
            str += " ${result[i][j]}"
        }
        print(str)
        if (i != result.size - 1) {
            println()
        }
    }
}