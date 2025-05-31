

fun main() {
    val br = System.`in`.bufferedReader()
    val (v, e) = br.readLine().split(" ").map { it.toInt() }
    val adj = Array(v + 1) { mutableListOf<Int>() }
    repeat(e) {
        val (a, b) = br.readLine().split(" ").map { it.toInt() }
        adj[a].add(b)
        adj[b].add(a)
    }

    val visited = BooleanArray(v + 1)
    fun dfs(n: Int) {
        visited[n] = true
        for (u in adj[n]) {
            if (!visited[u]) dfs(u)
        }
    }

    val start = 1
    dfs(start)

    var connected = true
    if(visited.count{!it}!=1) {
        connected = false
    }

    val oddCount = (1..v).count { adj[it].size % 2 == 1 }


    if (connected && (oddCount == 0 || oddCount == 2))
        print("YES")
    else
        print("NO")
}