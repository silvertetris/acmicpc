

import kotlin.math.*

fun main() {
    val (N, K) = readln().split(" ").map { it.toInt() }

    var sum = 0L

    for (i in 1..K) {
        val BP = i.toDouble() * N / (K + 1)
        val CP = (N - BP)
        val AP = sqrt(BP * BP + N * N)

        val F_i = (AP * AP + BP * CP).toLong()
        sum += F_i
    }

    println(sum)
}
