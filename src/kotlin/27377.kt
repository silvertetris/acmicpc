package kotlin

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val T = br.readLine().toInt()
    repeat(T) {
        val n = br.readLine().toLong()
        val (s, t) = br.readLine().split(" ").map { it.toLong() }
        var minTime = s * n  //다 적었을 경우

        var m = 1
        while (true) {
            val twoPowerM = 1L shl m  // 2^m
            if (twoPowerM > n) break

            val k = n / twoPowerM
            val currentTime = s * (n - k) + m * t
            if (currentTime < minTime) {
                minTime = currentTime
            }
            m++
        }

        println(minTime)
    }
}