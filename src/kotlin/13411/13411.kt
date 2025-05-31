package kotlin.`13411`

import kotlin.math.pow

fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    val result=Array<Pair<Int, Double>>(n) {Pair(0, 0.0)}
    for(i in 0 until n) {
        val(x, y, v) = br.readLine().split(" ").map { it.toInt() }
        val dis = x.toDouble().pow(2) + y.toDouble().pow(2)
        result[i] = Pair(i+1, dis/v.toDouble().pow(2))
    }
    result.sortBy{it.second}
    for(i in result) {
        println("${i.first}")
    }
}