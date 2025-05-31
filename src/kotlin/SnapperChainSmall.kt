

import kotlin.math.pow

fun main() {
    val t = readln().toInt()
    val result = StringBuilder()
    for (i in 0 until t) {
        val (n, k) = readln().split(" ").map { it.toInt() }

        if ((k) % 2.0.pow(n).toInt() == 2.0.pow(n).toInt()-1) {
            result.append("Case #${i + 1}: ON\n")
        } else {
            result.append("Case #${i + 1}: OFF\n")
        }
    }
    print(result)
}