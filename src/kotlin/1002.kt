package kotlin

import kotlin.math.abs
import kotlin.math.pow

fun main() {
    val n = readln().toInt()
    var result: Array<Int> = Array(n) { 0 }
    for (i in 0 until n) {
        var map = readln().split(" ").map { it.toInt() }
        val x1 = map[0]
        val y1 = map[1]
        val r1 = map[2]
        val x2 = map[3]
        val y2 = map[4]
        val r2 = map[5]
        val xDistance = abs(x1 - x2).toDouble().pow(2.0)
        val yDistance = abs(y1 - y2).toDouble().pow(2.0)
        var distance = (xDistance + yDistance)
        if (distance == 0.0 && r1 == r2) {
            result[i] = -1 // 무한대의 교점
        } else if (distance > (r1 + r2).toDouble().pow(2) || distance < abs(r1 - r2).toDouble().pow(2)) {
            result[i] = 0 // 교점 없음
        } else if (abs(distance - (r1 + r2).toDouble().pow(2)) < 1e-9 || abs(distance - abs(r1 - r2).toDouble().pow(2)) < 1e-9) {
            result[i] = 1 // 접점 (외접 또는 내접)
        } else {
            result[i] = 2 // 두 점에서 만남
        }
    }
    for (i in result.indices) {
        println(result[i])
    }
}