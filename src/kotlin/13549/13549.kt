package kotlin.`13549`

import java.util.*

fun main() {
    val (n, k) = readln().split(" ").map { it.toInt() }
    val max = 100000
    val dist = IntArray(max * 2 + 1) { Int.MAX_VALUE }
    val deque: Deque<Int> = LinkedList()

    dist[n] = 0
    deque.add(n)

    while (deque.isNotEmpty()) {
        val x = deque.pollFirst()
        if (x == k) break

        if (x * 2 <= max * 2 && dist[x * 2] > dist[x]) {
            dist[x * 2] = dist[x]
            deque.addFirst(x * 2)
        }
        // 앞으로 한 칸(1초)
        if (x + 1 <= max * 2 && dist[x + 1] > dist[x] + 1) {
            dist[x + 1] = dist[x] + 1
            deque.addLast(x + 1)
        }
        // 뒤로 한 칸(1초)
        if (x - 1 >= 0 && dist[x - 1] > dist[x] + 1) {
            dist[x - 1] = dist[x] + 1
            deque.addLast(x - 1)
        }
    }
    println(dist[k])
}