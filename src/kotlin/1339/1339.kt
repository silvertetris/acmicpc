package kotlin.`1339`

import java.util.*

fun main() {
    val scanner = Scanner(System.`in`)
    val graph = IntArray(26)

    val n = scanner.nextInt()
    repeat(n) {
        val input = scanner.next()
        var pow = 1
        for (j in input.length - 1 downTo 0) {
            graph[input[j] - 'A'] += pow
            pow *= 10
        }
    }

    graph.sortDescending()

    var num = 9
    var answer = 0
    for (value in graph) {
        if (value == 0) break
        answer += value * num--
    }

    println(answer)
}