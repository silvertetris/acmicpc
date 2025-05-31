package kotlin.`1068`

fun main() {
    val n = readln().toInt()
    val parent = readln().split(" ").map { it.toInt() }
    val delete = readln().toInt()
    val adj = Array(n) { mutableListOf<Int>() }
    var root = -1

    for (i in 0 until n) {
        val p = parent[i]
        if (p == -1) {
            root = i
        } else {
            adj[p].add(i)
        }
    }

    val visited = BooleanArray(n)
    fun dfs(node: Int) {
        visited[node] = true
        for (child in adj[node]) {
            dfs(child)
        }
    }
    dfs(delete)

    var leafCount = 0
    for (i in 0 until n) {
        if (!visited[i]) {
            val check = adj[i].count { !visited[it] }
            if (check != 0) {
                leafCount++
            }
        }
    }

    if (visited[root]) {
        print(0)
    } else {
        print(leafCount)
    }
}