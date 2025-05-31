package kotlin

import kotlin.math.min

fun main() {
    val br = System.`in`.bufferedReader()
    val (n, m) = br.readLine()!!.split(" ").map { it.toInt() }
    var minPackage = Int.MAX_VALUE
    var minCnt = Int.MAX_VALUE

    repeat(m) {
        val temp = br.readLine().split(" ").map { it.toInt() }
        minPackage = min(minPackage, temp[0])
        minCnt = min(minCnt, temp[1])
    }

    if (minPackage > minCnt * 6) {
        print(n*minCnt)
    } else {
        val pack = n/6
        val cnt =n%6
        var result = pack* minPackage
        result += if(cnt*minCnt > minPackage) {
            minPackage
        } else {
            cnt*minCnt
        }
        print(result)
    }
}