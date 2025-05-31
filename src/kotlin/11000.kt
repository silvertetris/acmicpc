

import java.util.*

fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    val arr = ArrayList<Pair<Int, Int>>(n)
    for (i in 0 until n) {
        val (a, b) = br.readLine().split(" ").map { it.toInt() }
        arr.add(Pair(a, b))
    }
    arr.sortWith(compareBy<Pair<Int, Int>> { it.first }.thenBy { it.second })
    val q = PriorityQueue<Int>()
    for (i in arr.indices) {
        q.add(arr[i].second)
        if (q.peek() <= arr[i].first) {
            q.poll()
        }
    }
    print(q.size)
}