package kotlin

import java.io.BufferedWriter
import java.io.OutputStreamWriter

fun main() {
    val wb = BufferedWriter(OutputStreamWriter(System.out))
    var temp = 0
    while (true) {
        val n = readln().toInt()
        if (n == 0) break
        var list = HashMap<String, Pair<Int, Int>>()
        repeat(n) {
            val (a, b, c, d, e) = readln().split(" ")
            if (!list.containsKey(a)) list[a] = Pair(0, 0)
            if (!list.containsKey(e)) list[e] = Pair(0, 0)
            if (b > d) {
                list[a] = Pair(list[a]!!.first + 3, list[a]!!.second + (b.toInt() - d.toInt()))
                list[e] = Pair(list[e]!!.first, list[e]!!.second - (b.toInt() - d.toInt()))
            } else if (b == d) {
                list[a] = Pair(list[a]!!.first + 1, list[a]!!.second)
                list[e] = Pair(list[e]!!.first + 1, list[e]!!.second)
            } else {
                list[e] = Pair(list[e]!!.first + 3, list[e]!!.second + (d.toInt() - b.toInt()))
                list[a] = Pair(list[a]!!.first, list[a]!!.second - (d.toInt() - b.toInt()))
            }
        }
        for ((i, j) in list.entries.sortedWith(compareByDescending<MutableMap.MutableEntry<String, Pair<Int, Int>>> { it.value.first }.thenByDescending { it.value.second })) {
            wb.write("${j.first} ${i}\n")
        }
        wb.write("\n")
    }
    wb.flush()
    wb.close()
}