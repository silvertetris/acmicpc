

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))
    val (n, q, a) = reader.readLine()!!.split(' ').map { it.toInt() }
    val arr = reader.readLine()!!.split(' ').map { it.toLong() }
    repeat(q) {
        val (idx1, idx2) = reader.readLine()!!.split(" ").map { it.toInt() }
    }
    writer.flush()
}