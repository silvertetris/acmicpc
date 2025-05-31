package kotlin

import kotlin.math.pow

fun main() {
    val t = readln().toInt()
    val result = StringBuilder()
    repeat(t) {
        val (startX, startY, endX, endY) = readln().split(" ").map { it.toInt() }
        val n = readln().toInt()
        var cnt = 0
        var arr: Array<Triple<Int, Int, Int>> = Array(n) { Triple(0, 0, 0) }
        for (i in 0 until n) {
            val temp = readln().split(" ").map { it.toInt() }
            var no = 0
            arr[i] = Triple(temp[0], temp[1], temp[2])
            if (((startX - arr[i].first).toFloat().pow(2) + (startY - arr[i].second).toFloat()
                    .pow(2)).pow(0.5f) < arr[i].third
            ) {
                cnt++
                no = 1
            }
            if (((endX - arr[i].first).toFloat().pow(2) + (endY - arr[i].second).toFloat()
                    .pow(2)).pow(0.5f) < arr[i].third && no == 0
            ) {
                cnt++
            }
            if (((endX - arr[i].first).toFloat().pow(2) + (endY - arr[i].second).toFloat()
                    .pow(2)).pow(0.5f) < arr[i].third && no == 1
            ) {
                cnt--
            }

        }
        result.append("$cnt\n")
    }
    print(result)
}