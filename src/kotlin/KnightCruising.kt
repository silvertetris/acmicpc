

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))
    val n = reader.readLine()!!.toInt()

    repeat(n) {
        val (x, y, z) = reader.readLine()!!.split(" ").map { it.toLong() }
        if ((x + y + z) % 2 == 0L) {
            writer.write("YES\n")
        } else writer.write("NO\n")
    }
    writer.flush()
    writer.close()
}