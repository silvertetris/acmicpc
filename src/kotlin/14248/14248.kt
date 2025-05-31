

import java.util.*

fun main() {
    val sc = Scanner(System.`in`)
    val n = sc.nextLine().trim().toInt()
    val adj: List<MutableList<Int>> = List(n + 1) { mutableListOf() }

    for (i in 0 until n) {
        val a = sc.nextInt()
        if (i - a >= 0) {
            adj[i].add(i - a)
        }
        if (a + i < n) {
            adj[i].add(a + i)
        }
    }
    sc.nextLine()
    val start = sc.nextLine().trim().toInt()
    val visited = BooleanArray(n + 1) { false }
    var cnt = 0
    fun dfs(idx: Int) {
        visited[idx] = true
        cnt++
        for (neighbor in adj[idx]) {
            if (!visited[neighbor]) {
                dfs(neighbor)
            }
        }
    }
    dfs(start - 1)
    print(cnt)
}