package kotlin

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))

    while (true) {
        val n = reader.readLine() ?: break
        val len = n.length
        var isCyclic = true
        val doubled = n + n

        for (i in 2..len) {
            val product = multiplyLargeNumber(n, i)

            if (product.length != len || !doubled.contains(product)) {
                isCyclic = false
                break
            }
        }

        val result = if (isCyclic) {
            "$n is cyclic\n"
        } else {
            "$n is not cyclic\n"
        }

        writer.write(result)
        writer.flush()
    }
}

fun multiplyLargeNumber(number: String, multiplier: Int): String {
    val result = StringBuilder()
    var carry = 0

    for (i in number.length - 1 downTo 0) {
        val digit = number[i] - '0'
        val product = digit * multiplier + carry
        result.append(product % 10)
        carry = product / 10
    }

    if (carry > 0) {
        result.append(carry)
    }

    return result.reverse().toString()
}
