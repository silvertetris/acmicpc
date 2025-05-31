package kotlin.`11725`

fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    val adj = List(n+1) {mutableListOf<Int>()}
    repeat(n-1) {
        val (u, v) = br.readLine().split(" ").map { it.toInt() }
        adj[u].add(v)
        adj[v].add(u)
    }
    val answer = IntArray(n+1) {0}
    val visited = BooleanArray(n+1) {false}
    fun dfs(idx:Int) {
        visited[idx] = true
        for(i in adj[idx]) {
            if(!visited[i]) {
                dfs(i)
                answer[i] = idx
            }
        }
    }
    dfs(1)
    for(i in 2..n) {
        println(answer[i])
    }
}